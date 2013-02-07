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
 * Request handler "editPhone" - Edit Phone Request Handler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=training_charles_widgets.phoneInfo.editPhone
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class EditPhoneRequestHandler extends WbdRequestHandler
{

	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException
	{
     HttpServletRequest request = uh.getRequest();
     String phoneId = request.getParameter("phoneId");
     String phoneType = request.getParameter("phoneType");
     String phoneNumber =  request.getParameter("phoneNumber");
    
     
     
     try {
    	 
		Xpc xpc = uh.getXpc();
		xpc.start("phinza.D.phone", "update");
		xpc.attrib("phoneId", phoneId);
		xpc.attrib("phoneType", phoneType);
		xpc.attrib("phoneNumber", phoneNumber);
		xpc.run();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
     
     
     
        
	return true;
	}

}
