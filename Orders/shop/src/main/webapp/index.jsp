<!DOCTYPE html>
<html>
<head>
<body>

<%@ include file="/WEB-INF/view/header.jsp" %>


<div>

<div class="container " class="col-md-6">
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
					<tr class="col-md-3">
						<!-- 	<td>${product.pid }</td>
						<td>${product.pname}</td>
						<td>${product.quantity}</td>
						<td>${product.catid}</td>
						<td>${product.pprice}</td>     -->

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

</div>

<br><br><br><br><br><br><br><br><br><br><br><br>

<%@ include file ="/WEB-INF/view/footer.jsp" %>

</body>
</head>
</html>