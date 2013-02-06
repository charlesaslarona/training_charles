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

public class AddressInfoProductionHelper extends WbdProductionHelper
{
	
	private XData addressInfo;
	public String addressType;
	public String address;
	public String personId;
	public String addressId;

	public AddressInfoProductionHelper(Properties prop)
	{
		super(prop);
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		XpcSecurity credentials = ud.getCredentials();
		
		
		HttpServletRequest request = ((JspHelper)ud).getRequest();
		String addressId = request.getParameter("addressId");
		String personId = request.getParameter("personId");
		try {
			Xpc xpc = ud.getXpc();
			xpc.start("phinza.D.address", "select");
			xpc.attrib("personId", personId);
			this.addressInfo = xpc.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		

//		XNodes nodes = this.addressInfo.getNodes("/select/address");
//		nodes.next();
//
//		setAddress(nodes.getText("address"));
//        setAddressType(nodes.getText("addressType"));
//        setPersonId(nodes.getText("personId"));

        
 
		return null;
	}
	
	public String getPersonId(){
		return personId;
	}
	
	public void setPersonId(String personId){
		this.personId = personId;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddressType() {
		return addressType;
	}
	
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public XData getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(XData addressInfo) {
		this.addressInfo = addressInfo;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
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
