<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

	<div class="container" class="col-md-8">
		<h2>Login</h2>
		<form action="perform_login" align="center" method="post" role="form"
			modelAttribute="">
			<div class="form-group">
				<span><p style="color: red">Invalid username or password</p></span>
				<label>Email</label> <input type="text" id="email"
					placeholder="email" required="required">
			</div>

			<div class="form-group">
				<label>Password</label> <input type="password" id="password"
					placeholder="password" required="required">
			</div>
			<div class="form-group">
				<label></label> <input type="submit">
			</div>
		</form>
	</div>
</body>
</html>