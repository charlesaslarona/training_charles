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
<%@page import="tooltwist.training_charles.productionHelpers.SessionHandlerProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	SessionHandlerProductionHelper h = (SessionHandlerProductionHelper) helper;
	XData data = h.getData(jh);
%>

<!-- ********** INSERT HTML HERE ********** -->
<div %%idDefinition%% class="SessionHandler">
<h1>Session</h1>
<form method="POST">
<input type="hidden" id="loginNavPoint" name="loginNavPoint" value="%%loginNav%%"/>
<input type="hidden" id="sessionOp" class="sessionOp" name="op" value="training_charles_widgets.sessionHandler.session" />
<input type="submit" id="btnLogOut" name="btnLogOut" value="LOG OUT" />

</form>
</div>

<!--END-->
</body>
</html>
