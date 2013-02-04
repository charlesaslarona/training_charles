<!DOCTYPE html>
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
<%@page import="tooltwist.training_charles.productionHelpers.EditPageProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	EditPageProductionHelper h = (EditPageProductionHelper) helper;
	XData data = h.getData(jh);
%>

<!-- ********** INSERT HTML HERE ********** -->
<div %%idDefinition%% class="EditPage">
 <form method="POST" action="">
	<input type="hidden" name="backNavPoint" value="%%previousPage%%">
	<input type="hidden" name="op" value="training_charles_widgets.editPage.previous">
	<input type="hidden" id="saveOp" name="saveOp" value="op=training_charles_widgets.addressInfo.editAddress">
<table border="1">
<tr>
	<td>User ID:</td>
	<td><input type="text" id="personId" name="personId" value="<%=h.getPersonId()%>" readonly="readonly"></td>

<tr>
	<td>Username:</td>
    <td><input type="text" id="userName" name="userName" value="<%=h.getUserName()%>"></td>
</tr>

<tr>
	<td>First Name:</td>
    <td><input type="text" id="firstName" name="firstName" value="<%=h.getFirstName()%>"></td>
</tr>

<tr>
	<td>Last Name:</td>
    <td><input type="text" id="lastName" name="lastName" value="<%=h.getLastName()%>"></td>
</tr>

<tr>
	<td>Middle Name:</td>
    <td><input type="text" id="middleName" name="middleName" value="<%=h.getMiddleName()%>"></td>
</tr>


<tr>
	<td>Email:</td>
    <td><input type="text" id="email" name="email" value="<%=h.getEmail()%>"></td>
</tr>

<tr>
	<td>New Password:</td>
    <td><input type="text" id="password" name="password" value=""></td>
</tr>

<tr>
	<td>Re-Type New Password:</td>
    <td><input type="text" id="password" name="password" value=""></td>
</tr>


<tr>
    <td colspan="2"><input type="button" id="btnUpdate" name="btnUpdate" value="Update" /> &nbsp;
    

	<input type="submit" id="btnBack" name="back" value="Back To List Page" /></td>

</tr>

</table>

	</form>




</div>

<!--END-->
</body>
</html>
