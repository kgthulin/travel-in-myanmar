<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Hotel</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mycss2.css">
</head>
<body>
	<div class="container">
		<form id="contact" action="UpdateHotelAction" method="post">
			<h3 align="center">Update Hotel</h3>
			<fieldset>
				<label>Id</label> 
				<s:textfield name="hotel_id" value="%{#request.hotel.hotel_id}" readonly="true" />
			</fieldset>
			<fieldset>
				<label for="name">Name</label> 
				<s:textfield name="name" value="%{#request.hotel.name}" />
			</fieldset>
			<fieldset>
				<label for="price">Price</label> 
				<s:textfield name="price" value="%{#request.hotel.price}" />
			</fieldset>
			<fieldset>
				<label for="rating">Rating</label> 
				<s:textfield name="rating" value="%{#request.hotel.rating}" />
			</fieldset>
			<fieldset>
				<label for="phone">Phone</label> 
				<s:textfield name="phone" value="%{#request.hotel.phone}" />
			</fieldset>
			<fieldset>
				<button name="submit" type="submit" id="contact-submit"
					data-submit="...Sending">Update</button>
			</fieldset>
		</form>
	</div>
</body>
</html>