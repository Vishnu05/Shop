<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
<script></script>
</head>

<div class="panel-heading">
                    <h3  align="left" class="panel-title"><span class="glyphicon glyphicon-user"></span> Administrator DashBoard</h3>
                    <h3 align="center" class="panel-title"><span class="glyphicon glyphicon-home"></span><a href="admin">Home</a></h3>
                    <h3 align="right" class="panel-title"><span class="glyphicon glyphicon-log-out"></span><a href="#">Logout</a></h3>
                </div>

<body>

	<form:form action="adduser" modelAttribute="user" method="POST">
		<div class="container">
			<h1>Registration Form</h1>
			<div>
				<label>Email</label>
				<form:input path="email" type="email"  required="required" />
			</div>
			<div>
				<label>Password</label>
				<form:input path="password" type="password" required="required"/>
			</div>

			<div>
				<label>Confirm password</label>
				<form:input path="confirmpassword" type="password" required="required"/>
			</div>

			<div>
				<label>Phone Number</label>
				<form:input path="phonenumber" required="required"/>
			</div>

			<div>
				<label>Full Name</label>
				<form:input path="fullname" type="text" required="required"/>
			</div>
			<div>
				<input type="submit" />
			</div>
		</div>
	</form:form>


</body>
</html>
