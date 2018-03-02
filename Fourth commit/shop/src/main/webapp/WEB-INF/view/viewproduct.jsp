<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
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

	<div class="container ">
		<table class="table table-striped">
			<thead>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Quantity</th>
				<th>Category ID</th>
				<th>Product price</th>
				<th>Product image</th>
				<th>Edit/ Delete</th>
			</tr>
			</thead>

			<tr>

				<c:forEach items="${proddetails}" var="product">
					<tr>
						<td>${product.pid }</td>
						<td>${product.pname}</td>
						<td>${product.quantity}</td>
						<td>${product.catid}</td>
						<td>${product.pprice}</td>
						<td> ${product.pimage}</td>
						<td>
						<a href="<c:url value="updateproduct/${product.pid}"/>">Update</a>
						<a href="<c:url value="deleteproduct/${product.pid }"/>">Delete</a>
						</td>
					</tr>
				</c:forEach>
				
				 <sec:authorize >
				 </sec:authorize>
			</tr>
		</table>
	</div>
</body>
</html>