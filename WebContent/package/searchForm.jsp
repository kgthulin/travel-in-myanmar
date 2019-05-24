<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Search Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="fonts2/material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="vendor/jquery-ui/jquery-ui.min.css">
<link rel="stylesheet" href="css/style2.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mycss.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mycss3.css">
	<link href="https://fonts.googleapis.com/css?family=Acme"
	rel="stylesheet">
<style>
.fo {
	font-family: 'Acme', sans-serif;
}
</style>
</head>
<body
	style="background-image: url('img/bgimage.jpg'); background-size: cover;">
	<div class="main">
		<div class="topnav">
			<div class="topnav-right fo">
				<s:url id="search" action="setupForSearchForm" />
				<s:a href="%{search}">Search</s:a>
				<s:url id="ownPack" action="YourPackageAction" />
				<s:a href="%{ownPack}">Your Package</s:a>
				<a href="#" id="demo">Your Profile</a>
				<s:url id="logout" action="LogOutAction" />
				<s:a href="%{logout}">LogOut</s:a>
			</div>
		</div>
		<div class="header">
			<h1 class="fo">Travel in Myanmar</h1>
		</div>
		<div class="container">
		<div id="de"
			class="fo"
			style="font-size: 17px;color: black; display: none; padding: 8px; background: #d9d9d9; width: 235px; height: 50; position: absolute; left: 80%; top: 63px; z-index: 1; border-radius: 2px;">
			<s:property value="#session.userSession.name" />
			<br>
			<s:property value="#session.userSession.email" />
		</div>
		<script>
			var a = document.getElementById("demo");
			a.addEventListener("mouseover", myFunc);
			a.addEventListener("mouseout", myFunc);
			function myFunc() {
				var x = document.getElementById("de");
				if (x.style.display === "none") {
					x.style.display = "block";
				} else {
					x.style.display = "none";
				}
			}
		</script>
			<form id="booking-form" class="booking-form"
				action="SearchPackageAction" method="POST">
				<div class="form-group">
					<div class="form-destination">
						<label for="location" class="fo">Location</label>
						<s:select name="location.location_id" list="locationList"
							listKey="location_id" listValue="name" style="border:none;" />
					</div>
					<div class="form-destination">
						<label for="price" class="fo">Price (in MMK)</label> <input type="text" name="price"
							id="price" placeholder="Enter Price" pattern="[0-9]+" title="Must be numbers." required />
					</div>
					<div class="form-submit">
						<input type="submit" id="submit" class="submit" value="Search" />
					</div>
				</div>
			</form>
		</div>

	</div>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/jquery-ui/jquery-ui.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>