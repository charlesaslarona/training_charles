package tooltwist.training_charles.requestHandlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jruby.compiler.ir.operands.Array;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.dinaa.data.XData;
import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "location" - Location Request Handler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=training_charles_widgets.weather.location
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class LocationRequestHandler extends WbdRequestHandler
{
   public ArrayList<String> iconsList = new ArrayList<String>();
	 JSONObject json = new JSONObject();
	JSONArray arrIcons = new JSONArray();
	JSONArray arrTemps = new JSONArray();
	JSONArray arrDates =  new JSONArray();
	
	//API for future weather forecast
    //http://free.worldweatheronline.com/feed/weather.ashx?q=angeles+city,philippines&format=xml&num_of_days=5&key=43edf02a10004944131402
	@Override
	
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException
	{
		
		HttpServletRequest request = uh.getRequest();
		String location = request.getParameter("location");
		String woeid = getLocationId(location);
		fetchFutureWeather(location);
		parseWeather(uh, woeid);


		return true;
	}
	
	public void fetchFutureWeather(String location){
		String url = "http://free.worldweatheronline.com/feed/weather.ashx?q=" + location + "&format=xml&num_of_days=5&key=43edf02a10004944131402";
		arrIcons.clear();
		arrTemps.clear();
		arrDates.clear();
		try{

			 XData output = new XData(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url));
			 String iconUrl = output.getText("current_condition/weatherIconUrl");
			 String icon = iconUrl.replaceAll("<![CDATA[|]]>", "");
			 //System.out.println("OLD IMAGE" + iconUrl);
			 System.out.println("ICON IMAGE: " + icon);

			 
			 //Loop all the future weather icons
			 Element elem = output.getRootElement();
			 NodeList nodeList = elem.getElementsByTagName("weatherIconUrl");	
			 for (int i = 1; i < nodeList.getLength(); i++) {
			        Node node = nodeList.item(i);
			        if (node.getNodeType() == Node.ELEMENT_NODE) {
			          arrIcons.add(node.getTextContent());
		          
			        }
			    }
	          json.put("icons", arrIcons);

	          NodeList nodeListTemp = elem.getElementsByTagName("tempMaxC");
	          for (int i = 0; i < nodeListTemp.getLength(); i++){
	        	  Node node = nodeListTemp.item(i);
	        	  if (node.getNodeType() == Node.ELEMENT_NODE){
	        		  arrTemps.add(node.getTextContent() + (char)0x00B0 + "c");
	        	  }
	          }
	          
	          json.put("temps", arrTemps);
	          
	          String s = "";
	          String x;
	          NodeList nodeListDate= elem.getElementsByTagName("date");
	          for (int i = 0; i < nodeListDate.getLength(); i++){
	        	  Node node = nodeListDate.item(i);
	        	  if (node.getNodeType() == Node.ELEMENT_NODE){
	        		  s = node.getTextContent();
	        		  x = s.substring(s.lastIndexOf("-") + 1);
	        		  arrDates.add(x);
	        		  System.out.println("DATE IS " + arrDates.get(i));
	        		  System.out.println("Length of ArrDates " + arrDates.size());
	           		  System.out.println("X IS " + x);
	        	  }
	          }
	          
	          json.put("dates", arrDates);
			 
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	;
	public String getLocationId(String location){
		String url ="http://query.yahooapis.com/v1/public/yql?q=select * from geo.places where text='" + location + "'";
		String woeid = "";
		try{
		 XData output = new XData(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url));
		 woeid = output.getText("//place/woeid");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return woeid;
	}
	
	
	public void parseWeather(UimHelper uh, String locationId){
		String link = "";
		try {
			//api to get woeid
			//http://query.yahooapis.com/v1/public/yql?q=select*from%20geo.places%20where%20text=%22New%20York%22&format=xml
			//obrain woeid
			//http://query.yahooapis.com/v1/public/yql?q=select * from geo.places where text="sunnyvale, ca"
			 String url = "http://weather.yahooapis.com/forecastrss?w=" + locationId + "&u=c";
			 XData output = new XData(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url));
			 String html = output.getText("//item/description");
			 Document doc = Jsoup.parse(html);
			 org.jsoup.nodes.Element element = doc.select("img").first();
			 link = element.attr("src");
			 //setwImage(link);
			 System.out.println(link);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		try {
			 //String url = "http://weather.yahooapis.com/forecastrss?w=1198782&u=c";
			 String url = "http://weather.yahooapis.com/forecastrss?w=" + locationId + "&u=c";
			 XData output = new XData(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url));
			 System.out.println("the image" + output.getText("//item/description"));
			 
			 //Parse the html string
			 String html = output.getText("//item/description");

			 Element elem = output.getRootElement();

			 NodeList channelList = elem.getElementsByTagName("channel");		

			 for (int i = 0; i < 1; i++) {
				//--LOCATION--//
				 
				 Node cParentNode = channelList.item(0);
				 NodeList cChildList =  cParentNode.getChildNodes();
				 int cSize = cChildList.getLength();
				 
				 for (int j = 0; j < cSize; j++) {
						Node node = cChildList.item(j);
											
						if (node.getNodeName().equalsIgnoreCase("yweather:location")) {
							Element element = (Element) node;
							
							json.put("country",element.getAttribute("country"));
							json.put("city",element.getAttribute("city"));
							json.put("region", element.getAttribute("region"));



						}					
					}		
					 
				 
				 //--CONDITION--//
				 NodeList nodeList = elem.getElementsByTagName("item");	
				 
				 Node parentNode = nodeList.item(0);
				 NodeList childList =  parentNode.getChildNodes();
				 int size = childList.getLength();
				 
				 for (int j = 0; j < size; j++) {
					Node node = childList.item(j);
										
					if (node.getNodeName().equalsIgnoreCase("yweather:condition")) {
						Element element = (Element) node;
						
						json.put("text",element.getAttribute("text"));
						json.put("temp",element.getAttribute("temp"));
						json.put("code",element.getAttribute("code"));
						json.put("date",element.getAttribute("date"));
						json.put("img", link);
						System.out.println("text = " + element.getAttribute("text"));
						System.out.println("text = " + element.getAttribute("temp"));
						System.out.println("text = " + element.getAttribute("code"));
						System.out.println("text = " + element.getAttribute("date"));

						//--Pass the output
						//setwCondition(element.getAttribute("text"));
						//setwDate(element.getAttribute("date"));
						//setwCode(element.getAttribute("code"));
						//setwTemp(element.getAttribute("temp"));
					}					
				}		
				 
				 
				 
				HttpServletResponse response = uh.getResponse();
				 response.setContentType("application/json");
				 PrintWriter pw = response.getWriter();
				 pw.print(json);
				 pw.flush();
				 pw.close();
			 }

		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
	}


}
