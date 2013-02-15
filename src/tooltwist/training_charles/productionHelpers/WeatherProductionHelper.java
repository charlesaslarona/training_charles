package tooltwist.training_charles.productionHelpers;

import java.util.Properties;


import javax.xml.parsers.DocumentBuilderFactory;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import tooltwist.wbd.WbdProductionHelper;

import com.dinaa.data.XData;
import com.dinaa.ui.UimData;
import com.dinaa.xpc.XpcSecurity;
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.PostMethod;


public class WeatherProductionHelper extends WbdProductionHelper
{
	private static String AUTO_URL_PARAMETER_NAME = "myParam";
	private XData data = null;
	private String myValue;
	private String myAutoUrlParameter;
	private NodeList rateNodeList;
	public String wDate;
	public String wTemp;
	public String wCode;
	public String wCondition;
	public String wImage;
	public String mLocation;
	public String mCity;
	public String mCountry;

	public WeatherProductionHelper(Properties prop)
	{
		super(prop);
		parseWeather(12313);
		
		
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		XpcSecurity credentials = ud.getCredentials();
		 
		return null;
	}
	
	
	public void parseWeather(int areaId) {
		
		try {
			//api to get woeid
			//http://query.yahooapis.com/v1/public/yql?q=select*from%20geo.places%20where%20text=%22New%20York%22&format=xml
			//obrain woeid
			//http://query.yahooapis.com/v1/public/yql?q=select * from geo.places where text="sunnyvale, ca"
			 String url = "http://weather.yahooapis.com/forecastrss?w=1198782&u=c";
			 XData output = new XData(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url));
			 String html = output.getText("//item/description");
			 Document doc = Jsoup.parse(html);
			 org.jsoup.nodes.Element element = doc.select("img").first();
			 String link = element.attr("src");
			 setwImage(link);
			 System.out.println(link);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		try {
			 String url = "http://weather.yahooapis.com/forecastrss?w=1198782&u=c";
			 XData output = new XData(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url));
			 System.out.println("the image" + output.getText("//item/description"));
			 
			 //Parse the html string
			 String html = output.getText("//item/description");
			 
			 //Document doc = Jsoup.parse(html);
			 /*
			 org.jsoup.nodes.Element link =  doc.select("img").first();
			 String imgLink = link.attr("src");
			 System.out.println("IMAGE SOURCE: " + imgLink); */
			 Element elem = output.getRootElement();
			 NodeList nodeList = elem.getElementsByTagName("item");	
			 for (int i = 0; i < 1; i++) {
				 Node parentNode = nodeList.item(0);
				 NodeList childList =  parentNode.getChildNodes();
				 int size = childList.getLength();
				
				 for (int j = 0; j < size; j++) {
					Node node = childList.item(j);
					if (node.getNodeName().equalsIgnoreCase("yweather:condition")) {
						Element element = (Element) node;
						System.out.println("text = " + element.getAttribute("text"));
						System.out.println("text = " + element.getAttribute("temp"));
						System.out.println("text = " + element.getAttribute("code"));
						System.out.println("text = " + element.getAttribute("date"));
						//--Pass the output
						setwCondition(element.getAttribute("text"));
						setwDate(element.getAttribute("date"));
						setwCode(element.getAttribute("code"));
						setwTemp(element.getAttribute("temp"));
					}
					
				}				 
			 }
			 NodeList nodeChannel = elem.getElementsByTagName("channel");			 
			 for (int i = 0; i < 1; i++) {
				 Node parentNode = nodeChannel.item(0);
				 NodeList childList =  parentNode.getChildNodes();
				 int size = childList.getLength();
				
				 for (int j = 0; j < size; j++) {
					Node node = childList.item(j);
					if (node.getNodeName().equalsIgnoreCase("yweather:location")) {
						Element element = (Element) node;
						System.out.println("CITY = " + element.getAttribute("city"));
						System.out.println("COUNTRY = " + element.getAttribute("country"));
						setmCountry(element.getAttribute("country"));
						setmCity(element.getAttribute("city"));
						//--Pass the output
					}
					
				}				 
			 }

		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
	}

	public String getwDate() {
		return wDate;
	}

	public void setwDate(String wDate) {
		this.wDate = wDate;
	}

	public String getwCode() {
		return wCode;
	}

	public void setwCode(String wCode) {
		this.wCode = wCode;
	}

	public String getwCondition() {
		return wCondition;
	}

	public void setwCondition(String wCondition) {
		this.wCondition = wCondition;
	}
	

	public void setwTemp(String wTemp){
		this.wTemp = wTemp;
	}
	public String getwTemp(){
		return wTemp;
	}
	
	public String getwImage(){
		return wImage;
	}
	
	public void setwImage(String wImage){
		this.wImage = wImage;
	}
	
	public void setLocation(String location){
		mLocation = location;
	}
	
	public void setmCountry(String mCountry){
		this.mCountry = mCountry;
	}
	
	public String getCountry(){
		return mCountry;
	}
	
	public void setmCity(String mCity){
		this.mCity = mCity; 
	}
	
	public String getCity(){
		return mCity;
	}
}
