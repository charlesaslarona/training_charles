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
<%@page import="tooltwist.training_charles.productionHelpers.WeatherProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	WeatherProductionHelper h = (WeatherProductionHelper) helper;
	XData data = h.getData(jh);
%>

<!-- ********** INSERT HTML HERE ********** -->
<div %%idDefinition%% class="Weather">
	Weather 
	<!--  
<form method="post">
<input type="hidden" value="training_charles_widgets.weather.location" name="locationOP" id="locationOP"/>
<table>
<tr>
	<td colspan="2"><label id="place"><%=h.getCity() %> , &nbsp; <%=h.getCountry() %></label></td>
</tr>
<tr>
	<td><label id="temp"><%=h.getwTemp() %></label> &deg C</td>
	<td><img id="imgCondition" src="<%=h.getwImage() %>"/> </td>
</tr>
<tr>
	<td><label id="condition"><%=h.getwCondition() %></label></td>
	<td><label id="date"><%=h.getwDate() %></label></td>
</tr>

<tr>
	<td colspan="2">Enter a location: 
<input list="location" name="location" id="mLoc" placeholder="Enter a city">
<datalist id="location">
  <option value="Angeles City, PH">
  <option value="Mabalacat, PH">
  <option value="San Fernando, PH">
  <option value="Tarlac, PH">
  <option value="Capas, PH">
    <option value="Bamban, PH">
</datalist>
<input type="button" id="btnGo" value="GO"/>
	
</td>
</tr>
</tr>
</table>
</form> -->
<input type="hidden" value="training_charles_widgets.weather.location" name="locationOP" id="locationOP"/>
<div>
	<div class="weatherInfo"> <img id="imgTemp" src="<%=h.getwImage() %>">
	<div>
	  <label class="city"><%=h.getCity() %>,</label><br>
	  <label class="country"><%=h.getCountry() %></label><br><br>
	  <label id="date" class="date" ><%=h.getwDate() %></label>

	</div>
</div>

<div class="weatherBox">
<div class="lblTemp"><label id="temp"><%=h.getwTemp() %></label> <label style="color:white; font-size:50px;">&deg c</label></div>
<div class="dvCondition"><label id="condition"><%=h.getwCondition() %></label></div>
<div class="dvPlace"><input type="text" placeholder="Enter a city, country code" class="txtPlace" id="mLoc"/> <input type="button" name="" value="Go" class="css3button" id="btnGo"></div>
</div>

</div>


<!-- new Design -->
<br><br><br>
<br><br><br>
<br><br><br>
<br><br><br>
<br><br><br>
<br><br><br>
<div class="new-color">
<table class="presentWeather" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
		<label class="place"><%=h.getCity() %>,</label><br>
		<label class="mCountry"><%=h.getCountry() %></label>
		</td>
	    <td><img class="weatherIcon" src="<%=h.getwImage() %>" /></td>
	    <td><label class="temp"><%=h.getwTemp() %>&deg C <br> <%=h.getwCondition() %></label></td>
	</tr>
	<tr>
		<td colspan="3"><label class="mDate"><%=h.getwDate() %></label></td>
	</tr>
</table>

<table class="futureWeather" cellspacing="0" border="0" cellpadding="0">
	<tr>
		<th><label class ="date1"></label></th>
		<th><label class ="date2"></label></th>
		<th><label class ="date3"></label></th>
		<th><label class ="date4"></label></th>
		<th><label class ="date5"></label></th>
	</tr>
	<tr>
		<td><img class="img1"/></td>
		<td><img class="img2"/></td>
		<td><img class="img3"/></td>
		<td><img class="img4"/></td>
		<td><img class="img5"/></td>
	</tr>
	<tr>
		<td><label class="temp1"></label></td>
		<td><label class="temp2"></label></td>
		<td><label class="temp3"></label></td>
		<td><label class="temp4"></label></td>
		<td><label class="temp5"></label></td>
	</tr>
</table>
</div>

</div>

<!--END-->
</body>
</html>
