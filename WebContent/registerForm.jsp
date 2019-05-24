<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Register Form</title>
	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- Font-->
	<link rel="stylesheet" type="text/css" href="css/roboto-font.css">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-5/css/fontawesome-all.min.css">
	<!-- Main Style Css -->
    <link rel="stylesheet" href="css/styleForm.css"/>
    <link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<style>
		ul {
			list-style: none;
			padding-top: 15px;
		}
	</style>
</head>
<body>
	<div class="page-content">	
		<div class="form-v5-content">
			<form class="form-detail" action="RegisterAction" method="post"  style="margin-left: 15px;">		
				<h2>Register Account Form</h2>
				<s:if test="hasActionErrors()">
					<div class="alert alert-danger" style="padding-left:3px;width:95%;">
						<s:actionerror />
					</div>
				</s:if>
 				<div class="form-row">
					<label for="name">Full Name</label>
					<input type="text" name="name" id="name" class="input-text" placeholder="your name" required pattern="[A-Za-z ]{1,32}" title="Cannot contain numbers">
					<i class="fas fa-user"></i>
				</div>
				<div class="form-row">
					<label for="email">Your Email</label>
					<input type="text" name="email" id="email" class="input-text" placeholder="example@gmail.com" required pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}" 
							title="characters or numbers @ at least 4 characters">
					<i class="fas fa-envelope"></i>
				</div>
				<div id="notMatch"></div>
  				<div class="form-row">
					<label for="password">Password</label>
					<input id="p" type="password" name="password" id="password" class="input-text" placeholder="password" required>
					<i class="fas fa-lock"></i>
				</div>
				<div class="form-row">
					<label for="cpassword">Confirm Password</label>
					<input id="cp" onchange="myFunction()" type="password" name="cpassword" id="cpassword" class="input-text" placeholder="confirm password" required>
					<i class="fas fa-lock"></i>
				</div>
				<div class="form-row-last">
					<input type="submit" onclick="myFunction()" name="register" class="register" value="Register">
				</div>
			</form>
		</div>
	</div>
</body>
</html>