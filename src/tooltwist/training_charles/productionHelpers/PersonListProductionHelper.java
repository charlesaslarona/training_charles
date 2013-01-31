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

public class PersonListProductionHelper extends WbdProductionHelper
{
	private static String AUTO_URL_PARAMETER_NAME = "myParam";
	private XData data = null;
	private String myValue;
	private String myAutoUrlParameter;

	public PersonListProductionHelper(Properties prop)
	{
		super(prop);
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
	
		HttpServletRequest request = ((JspHelper)ud).getRequest();
		String filter = request.getParameter("filter");
		
		StringBuffer whereClause = new StringBuffer();
		if (filter !=null && !filter.equals("")) 
		{
			whereClause.append("<whereClause>");
				whereClause.append("<expr op='or' returnType='char'>");
					whereClause.append("<expr op='like' returnType='char' >");
						whereClause.append("<operand>firstName</operand>");
						whereClause.append("<operand type='literal'>%"+filter+"%</operand>");
					whereClause.append("</expr>");
					whereClause.append("<expr op='like' returnType='char' >");
						whereClause.append("<operand>middleName</operand>");
						whereClause.append("<operand type='literal'>%"+filter+"%</operand>");
					whereClause.append("</expr>");
						whereClause.append("<expr op='like' returnType='char' >");
						whereClause.append("<operand>lastName</operand>");
						whereClause.append("<operand type='literal'>%"+filter+"%</operand>");
					whereClause.append("</expr>");						
					whereClause.append("<expr op='like' returnType='char' >");
						whereClause.append("<operand>userName</operand>");
						whereClause.append("<operand type='literal'>%"+filter+"%</operand>");
					whereClause.append("</expr>");
				whereClause.append("</expr>");	
			whereClause.append("</whereClause>");
		}
		Xpc xpc = ud.getXpc();
		xpc.start("phinza.D.person", "select");
		xpc.input(whereClause.toString());
		XData data = xpc.run();


		return data;
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
