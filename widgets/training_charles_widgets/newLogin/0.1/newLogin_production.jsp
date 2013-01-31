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
<%@page import="tooltwist.training_charles.productionHelpers.NewLoginProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	NewLoginProductionHelper h = (NewLoginProductionHelper) helper;
	XData data = h.getData(jh);
%>

<!-- ********** INSERT HTML HERE ********** -->
<div %%idDefinition%% class="NewLogin">
LOGIN PAGE
<form method="POST">
<input type="hidden" name="editOp" id="editOp" value=%%infoPage%% id="editOp" />
<input type="hidden" name = "loginOp" id="loginOp" value="training_charles_widgets.newLogin.login">
<table border="1">
<tr>
 <th>User Name: </th>
 <th>Password: </th>
</tr>

<tr>
	<td><input type="text" id="uName" name="uName" value="" placeholder="User Name" autocomplete="off"/></td>
	<td><input type="password" id="pWord" name="pWord" value="" placeholder="Password" autocomplete="off"/></td>
</tr>

<tr>
    <td colspan="2"><a href="%%infoPage%%" id="register"> Sign Up </a> or <input type="button" value="LOGIN" id="btnLogin"/></td>
</tr>
</table>
</form>
</div>

<!--END-->
</body>
</html>
