<%@ page language="java" import="com.moxman.model.Product" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>


<div class="container"> 
<table class="table">

<tr>
		<td rowspan="5">
			<img src="<c:url value="/images/${product.pid}.jpg" />"style="height: 400px; width: 50%"/>
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>Product ID :${product.pid}</td>
	</tr>
	<tr>
		<td>Product Name:${product.pname}</td>
	</tr>
	<tr>
		<td>Product Desc:${product.description}</td>
	</tr>
	<tr>
		<td>Product Price:${product.pprice}</td>
	</tr>
	
	
	<tr>
		 <td>	<c:if test="${username != null}">
						<a href="addcartproduct/${product.productName}"
							class="btn btn-default add-to-cart"><i
							class="fa fa-shopping-cart"></i>Add to cart</a>
					</c:if>
					<c:if test="${username == null}">
						<a href="login" class="btn btn-default add-to-cart"><i
							class="fa fa-shopping-cart"></i>Add to cart</a>
					</c:if>
					
					</td>
					</tr>
		  
		 <td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>



</table>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
 

</body>
</html>
