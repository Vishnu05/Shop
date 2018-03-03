<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	 

<link rel="stlyesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Product Display</title>
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
					<!--	<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Quantity</th>
				<th>Category ID</th>
				<th>Product price</th>
					<th>Cart</th>  -->
					<th>Product Image</th>
				
				</tr>
			</thead>

			<tr>

				<c:forEach items="${proddetails}" var="product">
					<tr>
						<!-- 	<td>${product.pid }</td>
						<td>${product.pname}</td>
						<td>${product.quantity}</td>
						<td>${product.catid}</td>
						<td>${product.pprice}</td>     -->
						<td><a href="productdescrption"> <img
								src="<c:url value="/images/${product.pid }.jpg"/>"
								style="height: 200px; width: 40%" alt="Error on loading images" /></a>
						<div><p style=font-size:20px >${product.pname} &emsp; &emsp; <i class="fas fa-rupee-sign"></i> Rate=${product.pprice}</p></div>
							<div>
								<a href="addcart/${product.pname }" class="btn btn-info">Add To Cart </a>
								
								 
								
							</div></td>
						<!-- 	<td><div ><a href="cart" class="btn btn-info">Add To Cart</a></div></td>  -->
					</tr>
				</c:forEach>

				<sec:authorize>
				</sec:authorize>
			</tr>
		</table>
	</div>

</body>
</html>