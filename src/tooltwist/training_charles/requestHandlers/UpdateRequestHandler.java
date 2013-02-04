package tooltwist.training_charles.requestHandlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcException;

import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "update" - Update Request Hanlder
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=training_charles_widgets.editPage.update
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class UpdateRequestHandler extends WbdRequestHandler
{

	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException
	{
		HttpServletRequest request = uh.getRequest();
		String personId = request.getParameter("personId");
		String userName = request.getParameter("userName");
		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		try {
			Xpc xpc = uh.getXpc();
			xpc.start("phinza.D.person", "update");
			xpc.attrib("personId", personId);
			xpc.attrib("userName", userName);
			xpc.attrib("firstName", firstName);
			xpc.attrib("middleName", middleName);
			xpc.attrib("lastName", lastName);
			xpc.attrib("email", email);
			xpc.run();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return true;
	}

}
