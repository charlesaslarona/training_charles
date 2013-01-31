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
<form method="POST" action="">
<input type="hidden" name="backNavPoint" value="%%previousPage%%">
<input type="hidden" name="op" value="training_charles_widgets.registrationPage.back">
<input type="hidden" name = "saveOp" id="saveOp" value="training_charles_widgets.registrationPage.save">
Person ID: <input type="text" id="personId" value="<%=h.getPersonId() %>" name="personId" class="textbox"/><br>
First Name: <input type="text" id="firstName" value="<%=h.getFirstName() %>"  name="firstName" /><br>
Middle Name: <input type="text" id="middleName"  value="<%=h.getMiddleName()  %>"  name="middleName" /><br>
Last Name:  <input type="text" id="lastName"  value="<%=h.getLastName() %>" name="lastName"/><br>
User Name: <input type="text" id="userName" value="<%=h.getUserName() %>"  name="userName"/><br>
Password: <input type="password" id="passWord" value="<%= %>" name="passWord" /> <br>
<input type="button"  id="btnSubmit" value="Submit"/>
<input type="submit" id="btnBack" value="back">
</form>

</div>

<!--END-->
</body>
</html>
