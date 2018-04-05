<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

<div class="container " class="col-md-6">
		<table class="table table-striped">
			<thead>
				<tr>
					 
					<th>Product Image</th>

				</tr>
			</thead>

			<tr>

				<c:forEach items="${proddetails}" var="product">
					<tr class="col-md-3">
						 

						<td><a href="productdescription?id=${product.pid}"> <img
								src="<c:url value="/images/${product.pid }.jpg"/>"
								style="height: 200px; width: 100%" alt="Error on loading images" /></a>
							
							
							
							
							<div>
								<a href="addcart/${product.pname}" class="btn btn-info">Add
									To Cart </a>

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