package tooltwist.training_charles.requestHandlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "session" - Session Request Handler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=training_charles_widgets.sessionHandler.session
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */

public class SessionRequestHandler extends WbdRequestHandler
{
    public void setSession() {
    	
    }
	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException
	{
		
		HttpServletRequest request = uh.getRequest();
	
		request.getSession().setAttribute("isLoggedIn", false);
		uh.getResponse().sendRedirect("/ttsvr/n/charles-11");
//		boolean isLoggedIn = (Boolean) request.getSession().getAttribute("isLoggedIn");
//		String loginNavPoint = request.getParameter("loginOp");
//		if (isLoggedIn){
//			//uh.getResponse().sendRedirect(loginNavPoint);
//
//		}
//		else {
//
//		//add handler
//		}
      return true;
	}

}
