package tooltwist.training_charles.requestHandlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.dinaa.data.XData;
import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import com.dinaa.xpc.Xpc;

import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "login" - Login Handler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=training_charles_widgets.newLogin.login
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class LoginRequestHandler extends WbdRequestHandler
{

	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException
	{
		
       HttpServletRequest request = uh.getRequest();
       String uName = request.getParameter("uName");
       String pWord = request.getParameter("pWord");
       boolean isCredentialsValid = isCredentialsValid(uh, uName, pWord);
       
      if (isCredentialsValid) {
        uh.reply("true");
        request.getSession().setAttribute("isLoggedIn", true);
      }
      else
    	  uh.reply("false");
       //validate credentials 
		return true;
	}
	
    public boolean isCredentialsValid(UimHelper uh, String userName, String passWord)
    {
    	//query to validate credentials
    	try {
    		String whereClause = "" +
					"<whereClause>" +
						" <expr op='and' returnType='char' >" +
					                "<expr op='eq' returnType='char' >" +
					                	"<operand>userName</operand>" +
					                	"<operand type='literal'>"+userName+"</operand>" +
					                "</expr>" +
					                "<expr op='eq' returnType='char'>" +
					                	"<operand>password</operand>" +
					                	"<operand type='literal'>"+passWord+"</operand>" +
					                	"</expr>" +
					     " </expr>" +
					"</whereClause>";
    		
			Xpc xpc = uh.getXpc();
			xpc.start("phinza.D.person", "select");
			xpc.input(whereClause);
			XData data = xpc.run();
			if (data.getRootType().equals("select")){
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
 	   return false;
    }

}
