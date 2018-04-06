<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<%@ include file="header.jsp"%>
<head>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="form-group">

		<div align="center">
			<h3>Getting Order Details</h3>
		</div>
		<br> <br>
		<form action="getorders" method="get" >
			<div class="col-md-4">
				<label>FROM</label><br> <input   type="date"
					required="required" name = "fromdate ">
<!-- i have no property like that ?  is this property should exists in table or dummy?wait asshole lol -->
			</div>

			<div class="col-md-4">
				<label>TO</label><br> <input type="date"
					required="required" name="todate">
			</div>



			<div class="col-md-1">
				<br> <input type="submit" value="getlist">
			</div>
		</form>
	</div>

	<br>
	<br>
	<br>
	<div class="table">
		<table class="table" class="col-md-9"
			class="table table-striped table-bordered">

			<thead>
				<tr>
					<th>Orders</th>
					<th>Product</th>
					<th>Quantity</th>
					<th>Email</th>
				<tr>
			</thead>

			<c:forEach items="${vat}" var="order">

				<tr>
					 
					<td>${order.email}</td>
					<td>${order.orderid}</td>
					<td>${order.prodname}</td>
				</tr>

			</c:forEach>


		</table>
	</div>

</body>
</html>