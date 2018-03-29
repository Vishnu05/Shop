<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	<br>
	<br>
	<br>
	<diV class="container">
		<div class="form-group">

			<form:form action="shipadd" commandName="shipment" method="POST">
				<div>
					<h3 style="color: blue;">Shipping Address</h3>
				</div>
				
				<div class="col-md-6 col-sm-3">
					<label>Name</label>
					<form:input path="name" type="text" required="required" />
				</div>

				<div class="col-md-6 col-sm-3">
					<label>Phone Number</label>
					<form:input type="text" path="phonenumber" placeholder=""
						required="required" />
				</div>

				<div class="col-md-6 col-sm-3">
					<label>Door Number</label>
					<form:input type="text" path="doorno" required="required" />
				</div>

				<div class="col-md-6 col-sm-3">
					<label>Address 1</label>
					<form:input type="text" path="address1" required="required" />
				</div>

				<div class="col-md-6 col-sm-3">
					<label>Address 2 </label>
					<form:input type="text" path="address2" required="required" />
				</div>

				<div class="col-md-6 col-sm-3">
					<label>City </label>
					<form:input type="text" path="city" required="required" />
				</div>

				<div class="col-md-6 col-sm-3">
					<label> State </label>
					<form:input type="text" path="state" required="required" />
				</div>

				<div class="col-md-6 col-sm-3">
					<label>Pin Code </label>
					<form:input type="text" path="pincode" required="required" />
				</div>

				<div class="col-md-6 col-sm-3">
					<label>Country</label>
					<form:input type="text" path="country" required="required" />
				</div>
				<br>
				
				<div>
					<input type="submit" class="btn btn-btn-primary">
				</div>

			</form:form>

			<div class="colg-md-5">
				<a href="oderdetails" class="btn btn-info">Invoice Page</a>
			</div>

		</div>
	</diV>

</body>
</html>