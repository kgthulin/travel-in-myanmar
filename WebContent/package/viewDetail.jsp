<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Detail</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mycss.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.min.js">	
</script>
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top:10px;">
			<div class="col-md-12">
				<div style="text-align: right;">
					<s:url id="viewPackage" action="ViewPackageAction" />
					<s:a href="%{viewPackage}"
								cssClass="btn btn-info btn-md" role="button"
								aria-disabled="true">Back</s:a>
					<s:url id="logout" action="LogOutAction" />
					<s:a cssClass="btn btn-info btn-md" role="button" 
						href="%{logout}" aria-disabled="true">Log Out</s:a>
				</div>
			</div>
		</div>
		<div class="row">
			<table class="table table-hover"
				style="background: #adebeb; margin-top: 10px;">
				<thead>
					<tr>
						<th scope="col">No</th>
						<th scope="col">Location</th>
						<th scope="col">Hotel</th>
						<th scope="col">Restaurant</th>
						<th scope="col">Ticket</th>
						<th scope="col">Price</th>
						<th scope="col">Days</th>
						<th scope="col">Quantity</th>
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
							<td><s:property value="price" /></td>
							<td><s:property value="number_of_day" /></td>
							<td><s:property value="quantity" /></td>
<%-- 							<td>
								<s:url id="update" action="setUpForPackageUpdate">
									<s:param name="currentId" value="id" />
								</s:url> <s:a href="%{update}" cssClass="btn btn-info btn-sm"
									role="button" aria-disabled="true">Edit</s:a></td> --%>
							<td>
								<s:url id="delete" action="DeletePackageAction">
									<s:param name="currentId" value="id" />
								</s:url> 
								<s:a href="%{delete}" cssClass="btn btn-info btn-sm"
									role="button" aria-disabled="true">Delete</s:a></td>
						</tr>
					</s:iterator>
					<tr
						style="background: #cce5ff; text-align: center; margin-top: 10px;">
						<td colspan="10"><s:url id="viewPackage"
								action="ViewPackageAction" /> <s:a href="%{viewPackage}"
								cssClass="btn btn-info btn-md" role="button"
								aria-disabled="true">Back</s:a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>