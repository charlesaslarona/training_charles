package tooltwist.training_charles.requestHandlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import com.dinaa.xpc.Xpc;

import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "deleteAddress" - Delete Address Request Handler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=training_charles_widgets.addressInfo.deleteAddress
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class DeleteAddressRequestHandler extends WbdRequestHandler
{

	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException
	{

		HttpServletRequest request = uh.getRequest();
		String addressId = request.getParameter("addressId");
		
	 try {
		Xpc xpc = uh.getXpc();
		xpc.start("phinza.D.address", "delete");
		xpc.attrib("addressId", addressId);
		xpc.run();
	} catch (Exception e) {
		e.printStackTrace();
	}
		return true;
	}

}
