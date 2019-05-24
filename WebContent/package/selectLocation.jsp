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
		<form id="contact" action="setUpForAddPackage" method="post">
			<h3 align="center">Please select location you want to create</h3>
			<fieldset>
				<label>Location</label><br>
				<s:select name="location.location_id" list="locationList" listKey="location_id" 
							listValue="name" tabindex="2" style="width:100%;height:35px;" id="sec" />
			</fieldset>
			<fieldset>
				<button name="submit" type="submit" id="contact-submit"
					data-submit="...Sending">Go</button>
			</fieldset>
		</form>
	</div>
</body>
</html>