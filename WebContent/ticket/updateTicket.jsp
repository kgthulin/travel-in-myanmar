<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Ticket</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mycss2.css">
</head>
<body>
	<div class="container">
		<form id="contact" action="UpdateTicketAction" method="post">
			<h3 align="center">Update Ticket</h3>
			<fieldset>
				<label>Id</label> 
				<s:textfield name="ticket_id" value="%{#request.ticket.ticket_id}" readonly="true" />
			</fieldset>
			<fieldset>
				<label for="name">Name of Line</label> 
				<s:textfield name="line_name" value="%{#request.ticket.line_name}" />
			</fieldset>
			<fieldset>
				<label for="price">Price</label> 
				<s:textfield name="price" value="%{#request.ticket.price}" />
			</fieldset>
			<fieldset>
				<button name="submit" type="submit" id="contact-submit"
					data-submit="...Sending">Update</button>
			</fieldset>
		</form>
	</div>
</body>
</html>