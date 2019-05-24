<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Location</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mycss2.css">
</head>
<body>
	<div class="container">
		<form id="contact" action="AddLocationAction" method="post">
			<h3 align="center">Add New Location</h3>
			<fieldset>
				<label for="name">Name</label> <input type="text" name="name" pattern="[A-Za-z ]{1,32}"
					tabindex="1" required autofocus>
			</fieldset>
			<fieldset>
				<label for="mile">Number of Miles</label> <input type="text"
					name="mile" tabindex="2" id="mile" pattern="[0-9]+.[0-9]+" title="Cannot contain characters." required>
			</fieldset>
			<fieldset>
				<button name="submit" type="submit" id="contact-submit"
					data-submit="...Sending">Add</button>
			</fieldset>
		</form>
	</div>
</body>
</html>