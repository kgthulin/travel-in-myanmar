<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Package</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mycss2.css">
</head>
<body>
	<div class="container">
		<form id="contact" action="UpdatePackageAction" method="post">
			<h3 align="center">Update Package</h3>
			<fieldset>
				<label>Id</label> 
				<s:textfield name="id" value="%{#request.pack.id}" readonly="true" />
			</fieldset>
			<fieldset>
				<label>Hotel</label><br>
				<s:select name="hotel.hotel_id" list="hotelList" listKey="hotel_id" 
							listValue="name" style="width:100%;height:35px;" id="sec" />
			</fieldset>
			<fieldset>
				<label>Restaurant</label><br>
				<s:select name="restaurant.restaurant_id" list="restaurantList" listKey="restaurant_id" 
							listValue="name" style="width:100%;height:35px;" id="sec" />
			</fieldset>
 			<fieldset>
				<label>Ticket</label><br>
				<s:select name="ticket.ticket_id" list="ticketList" listKey="ticket_id" 
							listValue="line_name" style="width:100%;height:35px;" id="sec" />
			</fieldset>
			<fieldset>
				<label for="number_of_day">Number of Day</label> 
				<s:textfield name="number_of_day" value="%{#request.pack.number_of_day}" />
			</fieldset>
			<fieldset>
				<label for="quantity">Quantity</label> 
				<s:textfield name="quantity" value="%{#request.pack.quantity}" />
			</fieldset>
			<fieldset>
				<button name="submit" type="submit" id="contact-submit"
					data-submit="...Sending">Update</button>
			</fieldset>
		</form>
	</div>
</body>
</html>