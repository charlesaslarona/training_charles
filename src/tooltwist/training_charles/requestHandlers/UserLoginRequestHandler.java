package tooltwist.training_charles.requestHandlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import com.dinaa.xpc.XpcSecurity;

import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "userLogin" - User Login
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=training_charles_widgets.loginPage.userLogin
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class UserLoginRequestHandler extends WbdRequestHandler
{
	
	
	 public class User {
		String _lastname;
		String _firstname;
		String _middlename;
		String _email;
		String _username;
		String _password;
		String _cpassword;
		
	}
	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws  UiModuleException, ServletException, IOException
	{
		
		HttpServletRequest req = uh.getRequest();
		String lastname = req.getParameter("lastname");
		String firstname = req.getParameter("firstname");
		String middlename = req.getParameter("middlename");
		String email =  req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String cpassword = req.getParameter("cpassword");
		System.out.println(lastname);
		
		
		User mUser = new User();
		mUser._lastname = lastname;
		mUser._firstname = firstname;
		mUser._middlename =middlename;
		mUser._email = email;
		mUser._username = username;
		mUser._password = password;
		mUser._cpassword = cpassword;

		
		
		System.out.println("hello");
		
		String x = "hello world";
		
		//req.setAttribute("email", email);
  
		
		//PrintWriter writer = uh.getResponse().getWriter();
		//writer.print("{success: \"hello\"}");
		
		return false;
	}

}
