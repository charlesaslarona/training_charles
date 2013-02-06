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
<div class="bodyBackGround" style="width: 1000px; height: 1000px;">
<div class="centerBody">
<form method="POST">
<input type="hidden" name="editOp" id="editOp" value=%%infoPage%% />
<input type="hidden" name="signUpOp" id="signUpOp" value=%%signUpPage%% />
<input type="hidden" name = "loginOp" id="loginOp" value="training_charles_widgets.newLogin.login">
<table style="margin: 0px auto">
<tr>
<td>Login with your username and password</td>
</tr>
<tr>
<td><br><br></td>
</tr>
<tr>
 <td>User Name: </td>
</tr>

<tr>
	<td><input type="text" id="uName" name="uName" value="" placeholder="User Name" autocomplete="off" class="textBox"/></td>

</tr>

<tr>
 <td>Password: </td>
</tr>
<tr>
	<td><input type="password" id="pWord" name="pWord" value="" placeholder="Password" autocomplete="off" class="textBox"/></td>
</tr>

<tr>
    <td colspan="2"><a href="%%signUpPage%%" id="register" style="color: white"> Sign Up </a> or <input type="button" value="LOGIN" id="btnLogin" class="btnLogin" style="float:right"/></td>
</tr>
</table>
</form>
</div>
</div>
</div>
<!--END-->
</body>
</html>
