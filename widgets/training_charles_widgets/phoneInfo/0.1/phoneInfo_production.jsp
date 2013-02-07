
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
<%@page import="tooltwist.training_charles.productionHelpers.PhoneInfoProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%@page import="com.dinaa.data.XNodes"%>
<%
	// Get the production helper for this widget
	PhoneInfoProductionHelper h = (PhoneInfoProductionHelper) helper;
	XData data = h.getData(jh);
%>

<!-- ********** INSERT HTML HERE ********** -->
<div %%idDefinition%% class="PhoneInfo">
<form method="POST" action="" value="update">
<input type="hidden" id="editPhoneOp" name="editPhoneOp" value="training_charles_widgets.phoneInfo.editPhone"/>
<table border="1">
	<tr>
	
		<th>Phone ID</th>
		<th>Phone Number</th>
		<th>Phone Type </th>
		<th></th>
	</tr>
			<%
				if(h.getPhoneInfo() instanceof XData) {
				XNodes nodes = h.getPhoneInfo().getNodes("/select/phone");
				for (nodes.first(); nodes.next();) {
			%>

	
	<tr>
	<td>
	 	<input type="hidden" value="<%=nodes.getText("phoneId") %>" class="phoneId"/>
		<%=nodes.getText("phoneId") %>
	</td>
	<td>
	<input type="hidden" value="<%=nodes.getText("number") %>" class="phoneNumber">
	<label class="editable phoneLabel" ><%=nodes.getText("phoneNumber") %></label>
	</td>
	    <td>
	    <select name="phoneType" class="phoneType" >
			<option value="<%=nodes.getText("phoneType") %>" selected><%=nodes.getText("phoneType") %></option>
			<option value="<%=nodes.getText("phoneType") %>">Home</option>
			<option value="<%=nodes.getText("phoneType") %>">Work</option>
			<option value="<%=nodes.getText("phoneType") %>">Others</option>
		</select>
		</td>
	    
	    <td>
	       <input type="hidden" class="personId" value="<%=nodes.getText("personId") %>" />
	    	<input type="button" class="btnEditPhone" name="<%=nodes.getText("phoneNumber") %>" value="Update" >
	    </td>
	</tr>
<%
				}
			}
%>

	
</table>
</form>


<form method="POST" action="">
<input type="hidden" value="<%= h.getPersonId() %>" name="personId" id="personId" />
<input type="hidden" value="training_charles_widgets.phoneInfo.addPhone"  name="addPhoneOp" id="addPhoneOp"/>
<table>
<tr>
<td>phone: <input type="text" name="phoneAdd" id="phoneAdd"/></td>
<td>
phone Type: 
<select name="phoneTypeAdd" id="phoneTypeAdd">
    <option value="">--Please Select--</option>
    <option value="Home">Home</option>
    <option value="Work">Work</option>
    <option value="Others">Others</option>
</select>
</td>
</tr>
<tr>
<td colspan="2"><input type="button" value="Add" class="button-action" id="btnAddPhone"></td>
</tr>
</table>


</form>

</div>

<!--END-->
</body>
</html>
