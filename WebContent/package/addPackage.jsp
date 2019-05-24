<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Package</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mycss2.css">
</head>
<body>
	<div class="container">
		<form id="contact" action="AddPackageAction" method="post">
			<h3 align="center">Add New Package</h3>
			<fieldset>
				<label>Location</label><br>
				<s:textfield name="location.location_id" value="%{location.location_id}" readonly="true" />
			</fieldset>
			<fieldset>
				<label>Hotel</label><br>
				<s:select name="hotel.hotel_id" list="hotelList" listKey="hotel_id" 
							listValue="name" tabindex="1" style="width:100%;height:35px;" id="sec" />
			</fieldset>
			<fieldset>
				<label>Restaurant</label><br>
				<s:select name="restaurant.restaurant_id" list="restaurantList" listKey="restaurant_id" 
							listValue="name" tabindex="2" style="width:100%;height:35px;" id="sec" />
			</fieldset>
 			<fieldset>
				<label>Ticket</label><br>
				<s:select name="ticket.ticket_id" list="ticketList" listKey="ticket_id" 
							listValue="line_name" tabindex="3" style="width:100%;height:35px;" id="sec" />
			</fieldset>
			<fieldset>
				<label for="number_of_day">Number of Day</label> <input type="text" name="number_of_day"
					tabindex="4" id="number_of_day" pattern="[0-9]+" title="Cannot contain characters." required>
			</fieldset>
			<fieldset>
				<label for="quantity">Quantity</label> <input type="text" name="quantity"
					tabindex="5" id="quantity" pattern="[0-9]+" title="Cannot contain characters." required>
			</fieldset>
			<fieldset>
				<button name="submit" type="submit" id="contact-submit"
					data-submit="...Sending">Add</button>
			</fieldset>
		</form>
	</div>
</body>
</html>