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
import com.dinaa.data.XNodes;
import com.dinaa.ui.UimData;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcSecurity;

public class RegistrationPageProductionHelper extends WbdProductionHelper
{

	private String personId;
	private String userName;
	private String firstName;
	private String middleName;
	private String lastName;

	public RegistrationPageProductionHelper(Properties prop)
	{
		super(prop);
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		XpcSecurity credentials = ud.getCredentials();
		HttpServletRequest request = ((JspHelper)ud).getRequest();
		String personId = request.getParameter("personId");
		
		Xpc xpc = ud.getXpc();
		xpc.start("phinza.D.person", "select");
		xpc.attrib("personId", personId);
		XData data = xpc.run();
		
		XNodes nodes = data.getNodes("/select/person");
		nodes.next();
		
		setPersonId(nodes.getText("personId"));
		setUserName(nodes.getText("userName"));
		setFirstName(nodes.getText("firstName"));
		setMiddleName(nodes.getText("middleName"));
		setLastName(nodes.getText("lastName"));
	  
		return null;
	}
	
	
	
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	public String getPersonId() {
		return this.personId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
