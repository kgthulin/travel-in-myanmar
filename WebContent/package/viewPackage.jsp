<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>View Package</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mycss.css">
	<link href="https://fonts.googleapis.com/css?family=Acme"
	rel="stylesheet">
<style>
.fo {
	font-family: 'Acme', sans-serif;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="width: 100%; height: 100px; background: #33cccc; margin-bottom: 20px;">
		<div class="fo" style="text-align: center; padding: 10px; padding-top: 15px; color: #f2f2f2;">
			<h3>Travel in Myanmar</h3>
			<h5>View All Packages</h5>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div style="margin-bottom: 10px; text-align: right;">
					<s:url id="detail" action="ViewDetailAction" />
					<s:a href="%{detail}" cssClass="btn btn-info btn-md" role="button"
						aria-disabled="true">View Detail</s:a>
					<s:url id="loc" action="setUpForPackageLocation" />
					<s:a href="%{loc}" cssClass="btn btn-info btn-md" tabindex="-1"
						role="button" aria-disabled="true">Create New Package</s:a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<div style="background-color: #5eb2b3">
					<ul class="nav flex-column">
						<li class="nav-item"><s:url id="viewPackage"
								action="ViewPackageAction" /> <s:a cssClass="nav-link active"
								href="%{viewPackage}">Package</s:a></li>
						<li class="nav-item"><s:url id="viewHotel"
								action="ViewHotelAction" /> <s:a cssClass="nav-link"
								href="%{viewHotel}">Hotel</s:a></li>
						<li class="nav-item"><s:url id="viewRes"
								action="ViewRestaurantAction" /> <s:a cssClass="nav-link"
								href="%{viewRes}">Restaurant</s:a></li>
						<li class="nav-item"><s:url id="viewTicket"
								action="ViewTicketAction" /> <s:a cssClass="nav-link"
								href="%{viewTicket}">Ticket</s:a></li>
						<li class="nav-item"><s:url id="viewLoc"
								action="ViewLocationAction" /> <s:a cssClass="nav-link"
								href="%{viewLoc}">Location</s:a></li>
						<li class="nav-item"><s:url id="viewUser"
								action="ViewUserAction" /> <s:a cssClass="nav-link"
								href="%{viewUser}">User</s:a></li>
						<li class="nav-item"><s:url id="logout" action="LogOutAction" />
							<s:a cssClass="nav-link" href="%{logout}">Log Out</s:a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-10">
				<table class="table table-hover" style="background: #adebeb">
					<thead>
						<tr>
							<th scope="col">No</th>
							<th scope="col">Location</th>
							<th scope="col">Hotel</th>
							<th scope="col">Restaurant</th>
							<th scope="col">Ticket</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="packageList" status="status">
							<tr>
								<th scope="row"><s:property value="#status.count" /></th>
								<td><s:property value="location.name" /></td>
								<td><s:property value="hotel.name" /></td>
								<td><s:property value="restaurant.name" /></td>
								<td><s:property value="ticket.line_name" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>