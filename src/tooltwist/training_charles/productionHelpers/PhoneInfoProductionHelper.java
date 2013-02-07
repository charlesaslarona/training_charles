package tooltwist.training_charles.productionHelpers;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.PostMethod;

import tooltwist.ecommerce.AutomaticUrlParametersMode;
import tooltwist.ecommerce.RoutingUIM;
import tooltwist.misc.JspHelper;
import tooltwist.wbd.WbdProductionHelper;
import tooltwist.wbd.WbdSession;

import com.dinaa.data.XData;
import com.dinaa.ui.UimData;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcSecurity;

public class PhoneInfoProductionHelper extends WbdProductionHelper
{
	private XData phoneInfo;
	public String phoneType;
	public String phone;
	public String personId;
	public String phoneId;

	public PhoneInfoProductionHelper(Properties prop)
	{
		super(prop);
	
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		XpcSecurity credentials = ud.getCredentials();
		
		
		HttpServletRequest request = ((JspHelper)ud).getRequest();
		//String phoneId = request.getParameter("phoneId");
		String personId = request.getParameter("personId");
		try {
			Xpc xpc = ud.getXpc();
			xpc.start("phinza.D.phone", "select");
			xpc.attrib("personId", personId);
			this.phoneInfo = xpc.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		


// Uncomment to use Automatic parameters
//		// Get automatic parameters from the session object (usually set by an interupt handler)
//		[[helper]].selectedLocation = WbdSession.getAutomaticUrlParameter(credentials, AUTO_URL_PARAMETER_NAME);

// Uncomment to get parameters passed here from the widget
//		// Get parameters passed to the production helper
//		[[helper]].someParameter = getParameter("someParameter");

		
// Uncomment to use XPC
//		// Select data using XPC
//		boolean OFFLINE_MODE = false;
//		if (OFFLINE_MODE)
//			data = dummyData();
//		else
//		{
//			// Select the data
//			Xpc xpc = ud.getXpc();
//			xpc.start(xpcName, "select");
//			xpc.attrib("someAttrib", value);
//			data = xpc.run();
//			
//			// Check the return type
//			if ( !data.getRootType().equals("select"))
//				throw new WbdException("Invalid data returned: unvalid xml root: " + data.getRootType());
//		}
//		
//		// Get a value from the XPC result
//		[[helper]].myValue = data.getText("/select/recordName/attributeName");

		
// Uncomment to use a navpoint URL
//		// Get a URL for a navpoint
//		String navpointId = getParameter("myNavpoint");
//		[[helper]].navpointUrl = RoutingUIM.navpointUrl(ud, navpointUrl, AutomaticUrlParametersMode.INSERT_AUTOMATIC_URL_PARAMETERS_NOW);

		
// Uncomment to call a web service
// (This will require commons-httpclient-x.x.jar to be included in the build path)
//		// Call a web service
//		HttpClient client = new HttpClient();
//		String url = "http://geocal10am.dyndns.org:10080/tenam/phone/FindDisplayCategoriesActive01/1";
//		PostMethod clientMethod = new PostMethod(url);
//		try {
//			// Send the request to the server
//			int status = client.executeMethod(clientMethod);
//			if (status == HttpStatus.SC_OK) {
//				String response = clientMethod.getResponseBodyAsString();
//				[[helper]].categories = new XData(response);
//			} else {
//				throw new WbdException("Unable to access web service: response code=" + status);
//			}
//        } catch (Exception ex) {
//			if ( !data.getRootType().equals("select"))
//					throw new WbdException("Invalid data returned: unvalid xml root: " + data.getRootType());
//        } finally {
//        	clientMethod.releaseConnection();
//        }
//        [[helper]].categories.sortElements("/*/*/category", "name", true);

		return null;
	}

	public XData getPhoneInfo() {
		return phoneInfo;
	}

	public void setPhoneInfo(XData phoneInfo) {
		this.phoneInfo = phoneInfo;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}

//	private String dummyData()
//	{
//		return ""
//		+"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
//		+ "<findDisplayCategoriesResponse01>\n"
//		+ " <categories>\n"
//		+ "  <category id=\"1\"><version>0</version><name>GROCERY</name></category>\n"
//		+ "  <category id=\"2\"><version>0</version><name>FASHION</name></category>\n"
//		+ "  <category id=\"3\"><version>0</version><name>HEALTH</name></category>\n"
//		+ "  <category id=\"4\"><version>0</version><name>AUTO</name></category>\n"
//		+ "  <category id=\"6\"><version>0</version><name>LIFESTYLE</name></category>\n"
//		+ "  <category id=\"5\"><version>0</version><name>HOME STUFF</name></category>\n"
//		+ "  <category id=\"7\"><version>0</version><name>SALES</name></category>\n"
//		+ "  <category id=\"9\"><version>0</version><name>SERVICES</name></category>\n"
//		+ " </categories>\n"
//		+ "</findDisplayCategoriesResponse01>\n";
//	}

//	public XData getCategories()
//	{
//		return [[helper]].categories;
//	}

//	public String getMyProperty()
//	{
//		return [[helper]].myProperty;
//	}
}
