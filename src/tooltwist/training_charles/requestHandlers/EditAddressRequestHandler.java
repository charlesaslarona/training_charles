package tooltwist.training_charles.requestHandlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import com.dinaa.xpc.Xpc;

import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "editAddress" - Edit Address Handler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=training_charles_widgets.addressInfo.editAddress
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class EditAddressRequestHandler extends WbdRequestHandler
{

	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException
	{
		HttpServletRequest request = uh.getRequest();
		String addressType = request.getParameter("addressType");
		String address = request.getParameter("address");
		String addressId = request.getParameter("addressId");
		
		try {
			Xpc xpc = uh.getXpc();
			xpc.start("phinza.D.address", "update");
			xpc.attrib("addressId", addressId);
			xpc.attrib("addressType", addressType);
			xpc.attrib("address", address);
			xpc.run();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return true;
	
	}

}
