<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                    <h3  align="left" class="panel-title"><span class="glyphicon glyphicon-user"></span> Administrator DashBoard</h3>
                    <h3 align="center" class="panel-title"><span class="glyphicon glyphicon-home"></span><a href="admin">Home</a></h3>
                    <h3 align="right" class="panel-title"><span class="glyphicon glyphicon-log-out"></span><a href="#">Logout</a></h3>
                </div>


<!-- Displaying the Category data using Table -->
<table class="table table-striped" >

	<tr bgcolor="#ff66ff">
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operations</td>
	</tr>
	<c:forEach items="${catdetail}" var="category">
		<tr bgcolor="#00ff99">
			<td>${category.catid}</td>
			<td>${category.catname}</td>
			<td>${category.catdescription}</td>
			<td><a href="<c:url value="deleteCategory/${category.catid}"/>">Delete</a>
				<a href="<c:url value="updateCategory/${category.catid}"/>">Update</a>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>