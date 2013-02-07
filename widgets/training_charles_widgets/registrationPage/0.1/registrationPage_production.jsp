<!DOCTYPE html>
<html>
<head>
<title></title>
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
<%@page import="tooltwist.training_charles.productionHelpers.RegistrationPageProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	RegistrationPageProductionHelper h = (RegistrationPageProductionHelper) helper;
	XData data = h.getData(jh);
%>

<!-- ********** INSERT HTML HERE ********** -->
<div %%idDefinition%% class="RegistrationPage">
<form method="POST">
<input type="hidden" name="editOp" id="editOp" value=%%infoPage%% />
<input type="hidden" name="backNavPoint" value="%%previousPage%%">
<input type="hidden" name="op" value="training_charles_widgets.registrationPage.back">
<input type="hidden" name = "saveOp" id="saveOp" value="training_charles_widgets.registrationPage.save">
First Name: <input type="text" id="firstName"  value="" name="firstName" autocomplete="off" required/><br>
Middle Name: <input type="text" id="middleName"  name="middleName" autocomplete="off" required/><br>
Last Name:  <input type="text" id="lastName" name="lastName" autocomplete="off" required/><br>
Email: <input type="email" id="email" name="email" autocomplete="off" required/> <br>
User Name: <input type="text" id="userName" name="userName" autocomplete="off" required/><br>
Password: <input type="password" id="passWord" name="passWord" autocomplete="off"/> <br>
Confirm Password: <input type="password" id="cPassWord" name="cPassWord" autocomplete="off" required />
<input type="button"  id="btnSubmit" value="Submit"/>
<input type="submit" id="btnBack" value="back">
</form>

</div>

<!--END-->
</body>
</html>
