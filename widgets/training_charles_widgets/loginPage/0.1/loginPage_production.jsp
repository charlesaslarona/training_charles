<!DOCTYPE HTML>
<html>
<head>
<title></title>
</script>
</head>
<body>
<%
	WbdProductionHelper helper = null;
	JspHelper jh = null;
	String snippetVar_myProperty;
	String snippetVar_thisNavpoint;
%>
<!--START-->
<%@page import="tooltwist.wbd.WbdProductionHelper"%>
<%@page import="com.dinaa.data.XData"%>
<%--
<%@page import="tooltwist.training_charles.productionHelpers.LoginPageProductionHelper"%>
--%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
//	LoginPageProductionHelper h = (LoginPageProductionHelper) helper;
//	XData data = h.getData(jh);
%>

<!-- ********** INSERT HTML HERE ********** -->
<div class="LoginPage">
<div class="main">
<article><br><br>&nbsp;&nbsp;Hi! We are glad to have you here, Sign-up for free today!</article>
<form name="LoginForm" class="caption" >
<div class="loginBox">
   <header><br><br><br><strong>Registration Form</strong></header><br><br>
	<label for="lastname">Last Name  </label> <br> <input id="lname" type="text" name="lastname" placeholder="Enter Your Last Name" class="textbox" autofocus> <br><br>
	<label for="firstname">First Name </label> <br> <input type="text" name="firstname" id="fname"/ placeholder="Enter Your First Name" class="textbox"> <br><br>
	<label for="middlename">Middle Name </label><br> <input type="text" name="middlename" id="mname" placeholder="Enter Your Middle Name" class="textbox"/><br><br>
	<label for="email">Email</label> <br> <input type="email" name="email" id="email" placeholder="Enter your email address (ex. yourname@example.com)" class="textbox"/> <br><br>
	<label for="username">Username</label><br> <input type="text" name="username" id="uname" placeholder="Enter your desired username (must be unique)" class="textbox"/> <br><br>
	<label for="password">Password </label> <br> <input type="password" name="password" id="pword" class="textbox" placeholder="Enter password (password must be hard to guess)"/><br><br>
	<label for="cpassword">Confirm Password </label><br> <input type="password" name="cpassword" id="cpass" class="textbox" placeholder="Confirm Your Password"/><br><br><br>
	<input type="button" value="Log In" class="btnSubmit" onclick="validateLogin()" style="margin-left:50px"/>&nbsp;&nbsp;
	<input type="button" value="Clear Values" class="btnSubmit" onclick="*"/><br>
	<div style="clear:both"></div>
	</div>
</form>
</div>
<script type="text/javascript">
var user = new Object();

function validateLogin() {
   if (document.getElementById("lname").value === "" ||
		document.getElementById("fname").value === "" ||
		document.getElementById("mname").value === "" ||
		document.getElementById("email").value === "" ||
		document.getElementById("pword").value === "" ||
		document.getElementById("cpass").value === "")
	   
	   alert("All Fields Are Required");
	  	   			
   else
 		if (document.getElementById("pword").value != document.getElementById("cpass").value) {
 			alert("Password must match the confirm password");
 		}
 		else
 			validateEmail(document.getElementById("email").value);
}

function validateEmail(email) {
		var x=email;
		var atpos=x.indexOf("@");
		var dotpos=x.lastIndexOf(".");
		if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
		 {
		  alert("You must enter a valid e-mail address");
		  return false;
		  }
		else
			getLoginInfo();
}

function getLoginInfo() {
	user.lastname = document.getElementById("lname").value;
	user.firstname = document.getElementById("fname").value;
	user.middlename = document.getElementById("mname").value;
	user.email =document.getElementById("email").value;
	user.password = document.getElementById("pword").value;
	user.confirmpassword = document.getElementById("cpass").value;
	
	var r=confirm("Registration is successful!, Do you want to view your record?");
	if (r)
		{
	jQuery.ajax({
    type: 'POST',
	cache: false,
 	url: "?op=training_charles_widgets.loginPage.userLogin",
	data: {
		subop:"SaveUserInformation",
		lastname:$("#lname").val(),
		firstname:$("#fname").val(),
		middlename:$("#mname").val(),
		email:$("#email").val(),
		username:$("#uname").val(),
		password:$("#pword").val(),
		cpassword:$("#cpass").val()
	},
	dataType: "json",
      async: false,
	   success: function(data) {
		   alert(data);
		   data = eval(data);
		if(data.success == "success") {
		 alert("Advertisement Save.");
		 }else {
		  alert("There has been an error. Advertisement not saved."); 
		  }
		}
        });
		}
	  

//alert(user.firstname);
}
</script>
</div>
<!--END-->
</body>
</html>
