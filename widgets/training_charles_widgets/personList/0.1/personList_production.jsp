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
	<%@page import="com.dinaa.data.XNodes"%>
	<%@page import="tooltwist.wbd.WbdProductionHelper"%>
	<%@page import="com.dinaa.data.XData"%>
	<%@page
		import="tooltwist.training_charles.productionHelpers.PersonListProductionHelper"%>
	<%@page import="tooltwist.misc.JspHelper"%>
	<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
	<%@page import="tooltwist.ecommerce.RoutingUIM"%>
	<%
		// Get the production helper for this widget
		PersonListProductionHelper h = (PersonListProductionHelper) helper;
		XData data = h.getData(jh);
	%>

	<!-- ********** INSERT HTML HERE ********** -->
	<div %%idDefinition%% class="PersonList">
		<h1>%%headerPage%%</h1>
		<h2>can you see this</h2>
		<table border="1" style="border: 1px solid">
			<tr>
				<th>Person Id</th>
				<th>User Name</th>
				<th>First name</th>
				<th>Middle Name</th>
				<th>Last Name</th>
				<th>E-Mail</th>

			</tr>
			<%
				XNodes nodes = data.getNodes("/select/person");
				for (nodes.first(); nodes.next();) {
			%>

			<tr>
				<td><a shref="%%registrationPage%%?personId=<%=nodes.getText("personId")%>"><%=nodes.getText("personId")%></a></td>
				<td><a href="%%registrationPage%%?personId=<%=nodes.getText("personId") %>"><%=nodes.getText("userName")%></a></td>
				<td><a href="%%registrationPage%%?personId=<%=nodes.getText("personId")%>"><%=nodes.getText("firstName")%></a></td>
				<td><a href="%%registrationPage%%?personId=<%=nodes.getText("personId")%>"><%=nodes.getText("middleName")%></a></td>
				<td><a href="%%registrationPage%%?personId=<%=nodes.getText("personId")%>"><%=nodes.getText("lastName")%></a></td>
				<td><a href="%%registrationPage%%?personId=<%=nodes.getText("personId")%>"><%=nodes.getText("email")%></a></td>
			</tr>
			<%
				}
				

			%>

		</table>

	</div>

	<!--END-->
</body>
</html>
