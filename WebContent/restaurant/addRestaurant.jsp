<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Restaurant</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mycss2.css">
</head>
<body>
	<div class="container">
		<form id="contact" action="AddRestaurantAction" method="post">
			<h3 align="center">Add New Restaurant</h3>
			<fieldset>
				<label for="name">Name</label> <input type="text" name="name" pattern="[A-Za-z ]{1,32}"
					tabindex="1" required autofocus>
			</fieldset>
			<fieldset>
				<label>Location</label><br>
				<s:select name="location.location_id" list="locationList" listKey="location_id" 
							listValue="name" tabindex="2" style="width:100%;height:35px;" id="sec" />
			</fieldset>
			<fieldset>
				<label for="price">Price</label> <input type="text" name="price"
					tabindex="3" id="price" pattern="[0-9]+" title="Cannot contain characters." required>
			</fieldset>
			<fieldset>
				<label for="phone">Phone</label> <input type="text" name="phone"
					tabindex="4" id="phone" pattern="[0-9]+" title="Cannot contain characters." required>
			</fieldset>
			<fieldset>
				<button name="submit" type="submit" id="contact-submit"
					data-submit="...Sending">Add</button>
			</fieldset>
		</form>
	</div>
</body>
</html>