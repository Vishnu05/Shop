<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>

<script type="text/javascript">


</script>
</head>
<body>

	<div class="panel-heading">
		<h3 align="left" class="panel-title">
			<span class="glyphicon glyphicon-user"></span> Administrator
			DashBoard
		</h3>
		<h3 align="center" class="panel-title">
			<span class="glyphicon glyphicon-home"></span><a href="admin">Home</a>
		</h3>
		<h3 align="right" class="panel-title">
			<span class="glyphicon glyphicon-log-out"></span><a href="#">Logout</a>
		</h3>
	</div>


	<div>

		<form:form commandName="coupons" action="addcoup" name="fm">
			<div>
				<h1>Coupons Generator</h1>

				<div>
					<label>Coupons ID</label>
					<form:input path="couponid" required="required" />
				</div>

				<div>
					<label>Expiry Date</label>
					<form:input path="expirydate" required="reqiured" />
				</div>

				<div>
					<label>Discount percent</label>
					<form:input path="percent" required="reqiured" />
				</div>
				<div>
					<input type="submit" />
				</div>
			</div>
		</form:form>

		<div>
			<div class="container">

				<table
					class="table table-striped table-bordered table-hover table-condensed">
					<thead>
						<tr>
							<th>ID</th>
							<th>Coupon ID</th>
							<th>Expiry Date</th>
							<th>Coupons Discount percent</th>
							<th>Created ON</th>
							<th>Operation</th>
						</tr>
					</thead>
					<tr>
						<c:forEach items="${couplist}" var="coupons">

							<tr>
								<td>${coupons.id}</td>
								<td>${coupons.couponid}</td>
								<td>${coupons.expirydate }</td>
								<td>${coupons.percent}</td>
								<td>${coupons.coupondate}</td>
								<td><a href="deletecouponid/${coupons.id} "> <span
										class="glyphicon glyphicon-trash"></span></a></td>
							</tr>

						</c:forEach>
					</tr>
				</table>
			</div>

		</div>
	</div>
</body>
</html>