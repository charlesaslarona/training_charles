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
<%@page import="tooltwist.training_charles.productionHelpers.AddressInfoProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	AddressInfoProductionHelper h = (AddressInfoProductionHelper) helper;
	XData data = h.getData(jh);
%>

<!-- ********** INSERT HTML HERE ********** -->
<div %%idDefinition%% class="AddressInfo">

<form method="POST" action="" value="update">
<input type="hidden" id="updateOp" name="updateOp" value="training_charles_widgets.addressInfo.editAddress"/>
<table border="1">
	<tr>
		<th>Address</th>
		<th>Address Type </th>
		<th></th>
	</tr>
	
	<tr>
	    <td class="editable" id="address" name="address"><%=h.getAddress() %></td>
	    <!-- <td class="cmbEditable"><%=h.getAddressType() %></td>-->
	    <td>
	    <select name="addressType" id="addressType" >
			<option value="0" selected><%=h.getAddressType() %></option>
			<option value="1">Home</option>
			<option value="2">Work</option>
			<option value="3">Others</option>
		</select>
		</td>
	    
	    <td><input type="button" id="btnUpdate" name="btnUpdate" value="Update" class="button-action"></td>
	</tr>
	
</table>
</form>


<form method="POST" action="">
<input type="hidden" value="<%= h.getPersonId() %>" name="personId" id="personId" />
<input type="hidden" value="training_charles_widgets.addressInfo.addAddress"  name="addOp" id="addOp"/>
<table>
<tr>
<td>Address: <input type="text" name="addressAdd" id="addressAdd"/></td>
<td>
Address Type: 
<select name="addressTypeAdd" id="addressTypeAdd">
    <option value="">--Please Select--</option>
    <option value="Home">Home</option>
    <option value="Work">Work</option>
    <option value="Others">Others</option>
</select>
</td>
</tr>
<tr>
<td colspan="2"><input type="button" value="Add" class="button-action" id="btnAdd"></td>
</tr>
</table>


</form>



</div>

<!--END-->
</body>
</html>
