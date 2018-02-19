<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<body>

<div class="panel-heading">
                    <h3  align="left" class="panel-title"><span class="glyphicon glyphicon-user"></span> Administrator DashBoard</h3>
                    <h3 align="center" class="panel-title"><span class="glyphicon glyphicon-home"></span><a href="admin">Home</a></h3>
                    <h3 align="right" class="panel-title"><span class="glyphicon glyphicon-log-out"></span><a href="#">Logout</a></h3>
                </div>
<!-- Category Form Started -->
<c:if test="${flag}">
<form action="UpdateCategory" method="post">
</c:if>
<c:if test="${!flag}">
<form action="AddCategory" method="post">
</c:if>

	<table align="center" cellspacing="2">
		<tr>
			<td colspan="2"><h3><b>Category Details</b></h3></td>
			<c:if test="${flag}">
			<input type="hidden" name="catid" value="${category.catid}" />
			</c:if>
		</tr>
		<tr>
			<td><h4><b>Category Name</b></h4></td>
			<c:if test="${flag}">
				<td><input type="text" name="catname" value="${category.catname}" /></td>
			</c:if>
			<c:if test="${!flag}">
				<td><input type="text" name="catname" required="true"/></td>
			</c:if>
		</tr>
		<tr>
			<td><h4><b>Category Description</b></h4></td>
			<c:if test="${flag}">
				<td><input type="text" name="catdescription" value="${category.catdescription}" required="true"/></td>
			</c:if>
			<c:if test="${!flag}">
			<td><input type="text" name="catdescription" /></td>
			</c:if>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="AddCategory" /></td>
		</tr>
	</table>
</form>

<!-- Category Form Completed -->


<!-- Completed Displaying Table -->
</body>
</html>