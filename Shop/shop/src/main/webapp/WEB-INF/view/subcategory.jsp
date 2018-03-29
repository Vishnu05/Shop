<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SubCategory</title>
</head>
<body>
<div class="panel-heading">
                    <h3  align="left" class="panel-title"><span class="glyphicon glyphicon-user"></span> Administrator DashBoard</h3>
                    <h3 align="center" class="panel-title"><span class="glyphicon glyphicon-home"></span><a href="admin">Home</a></h3>
                    <h3 align="right" class="panel-title"><span class="glyphicon glyphicon-log-out"></span><a href="#">Logout</a></h3>
</div>
<!-- Category Form Started -->
<c:if test="${flag}">
<form:form action="UpdateSubCategory"  modelAttribute="subcategory" method="post">
 	<table align="center" cellspacing="2">
 	
 	<tr>
 	<td><form:input type="hidden" path="subcatid" value="${subcategory.subcatid}" /></td>
 	</tr>
 	
 	
 	<tr>
 	<td><h4><b>Sub Category Name</b></h4></td>
 	<td><form:input type="text" path="subcatname" value="${subcategory.subcatname}" /></td>
 	</tr>
 	
 	
 	<tr>
 	<td><h4><b>Sub Category Description</b></h4></td>
 	<td><form:input type="text" path="subcatdescription" value="${subcategory.subcatdescription}" /></td>
 	</tr>
 	
 											<tr>
										    <td><h4><b>Category</b></h4></td>
										    <td>
										    <form:select path="catid" required="true">
																<form:option value="${subcategory.catid}" label="------Select----" />
																<form:options items="${catlist}" />
															</form:select>
										    </td>
										    </tr>
										    
						  <tr>
						<td colspan="2">
							<center><input type="submit" value="Update Subcategory"/></center>
						</td>
					</tr>
										    
		</table>			 
 	
 	
 	
 	
 	</form:form>
</c:if>
<c:if test="${!flag}">
					<form:form action="Addsubcategory" modelAttribute="subcategory">
					        <table align="center" cellspacing="2">
					  
									
					  
									   <tr>
									   <td><h4><b>Sub Category Name</b></h4></td>
									    <td><form:input type="text" path="subcatname" required="true"/></td>
									   </tr>
					   
									     <tr>
									     <td><h4><b>Sub Category Description</b></h4></td>
									    <td><form:input type="text" path="subcatdescription" required="true"/></td>
									    </tr>
					    
										    <tr>
										    <td><h4><b>Category</b></h4></td>
										    <td>
										    <form:select path="catid" required="true">
																<form:option value="0" label="------Select----" />
																<form:options items="${catlist}" />
															</form:select>
										    </td>
										    </tr>
										    
				    <tr>
						<td colspan="2">
							<center><input type="submit" value="ADD A NEW SUBCATEGORY"/></center>
						</td>
					</tr>
					 
					  
					  			</table>
					</form:form>
</c:if>

	

<!-- Category Form Completed -->

<!-- Displaying the Category data using Table -->
<table cellspacing="2" align="center" border="5" >

	<tr bgcolor="#ff66ff">
		<td>SubCategory ID</td>
		<td>SubCategory Name</td>
		<td>SubCategory Description</td>
		<td>Category ID</td>
		<td>Operations</td>
	</tr>
	<c:forEach items="${subcatdetail}" var="subcategory">
		<tr bgcolor="#00ff99">
			<td>${subcategory.subcatid}</td>
			<td>${subcategory.subcatname}</td>
			<td>${subcategory.subcatdescription}</td>
			<td>${subcategory.catid}</td>
			<td><a href="<c:url value="deletesubcategory/${subcategory.subcatid}"/>">Delete</a>
				<a href="<c:url value="updateSubcategory/${subcategory.subcatid}"/>">Update</a>
			</td>
		</tr>
	</c:forEach>
</table>
<!-- Completed Displaying Table -->
</body>
</html>