<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
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
		<form>
			<div class="col-md-4">
				<label>FROM</label><br> <input type="datetime-local"
					required="required">

			</div>

			<div class="col-md-4">
				<label>TO</label><br> <input type="datetime-local"
					required="required">
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
					<th>Customers</th>
				<tr>
			</thead>
			<c:forEach items="">

			</c:forEach>
		</table>
	</div>

</body>
</html>