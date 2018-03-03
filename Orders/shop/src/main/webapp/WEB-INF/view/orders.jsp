
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
table>tbody>tr>td, .table>tfoot>tr>td {
	vertical-align: middle;
}

@media screen and (max-width: 600px) {
	table#cart tbody td .form-control {
		width: 20%;
		display: inline !important;
	}
	.actions .btn {
		width: 36%;
		margin: 1.5em 0;
	}
	.actions .btn-info {
		float: left;
	}
	.actions .btn-danger {
		float: right;
	}
	table#cart thead {
		display: none;
	}
	table#cart tbody td {
		display: block;
		padding: .6rem;
		min-width: 320px;
	}
	table#cart tbody tr td:first-child {
		background: #333;
		color: #fff;
	}
	table#cart tbody td:before {
		content: attr(data-th);
		font-weight: bold;
		display: inline-block;
		width: 8rem;
	}
	h3.hidden {
		visibility: hidden
	}
	table#cart tfoot td {
		display: block;
	}
	table#cart tfoot td .btn {
		display: block;
	}
}
</style>
<script>
	$(document).ready(function() {
		update_amounts();
		// Fix: Invalid selector for the select fields
		$('select[name=qty]').change(update_amounts);
	});
	function update_amounts() {
		var sum = 0.0;
		$('#cart > tbody  > tr')
				.each(
						function() {
							var qty = $(this).find('option:selected').val();
							// Fix: price is in text, not in a form field
							// and it must be cleaned from the pound sign
							var uname = $(this).find('option:selected').val();
							var pname = $(this).find('#pn').text();
							var cid = $(this).find('#iid').text();
							var price = $(this).find('.price').text().replace(
									/[^\d.]/, '');
							var amount = (qty * price);
							sum += amount;
							$(this).find('.subtotal').text('Rs.' + amount);
							if (uname >= 1) {
								$(".status").html(
										"<font> Calculating...</font>");
								$
										.ajax({
											type : 'GET',
											url : '${pageContext.request.contextPath}/addquty/'
													+ uname
													+ '/'
													+ pname
													+ '/'
													+ cid,

											success : function(msg) {
												$(".status").html(msg);

											}
										});
							} else {
								$(".status")
										.html(
												"<font color=red>Quantity should be <b></b> greater than Three.</font>");

							}
						});
		$("a").click(function() {
			$("#w3s").attr("href", "placeorder/" + sum);
		});
		//just update the total to sum  
		$('.total').text('Rs.' + sum);

	}
</script>


<title>My Cart</title>
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
<br><br><br><br>
	<div class="container">
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 35%">Product</th>
					<th style="width: 15%">Product Image</th>
					<!--  	<th style="width:50%">Image</th>-->
					<th style="width: 10%">Price</th>
					<th style="width: 8%">Quantity</th>
					<th style="width: 22%" class="text-center">Subtotal</th>
					<th style="width: 10%"></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${orderitems}" var="orderitem">
					<tr>
						<td data-th="Product">

							<div class="row">

								<div class="col-sm-10">
									<h3 class="hidden" id="iid">
										   ${orderitem.orderid}  -->
									</h3>
									<h4 class="nomargin" id="pn">
										  ${orderitem.prodname} -->
									</h4>


								</div>
							</div>
						</td>
						<td>
							<h4>
								<!-- 	<img src="<c:url value="/images/${cartitem.proid}.jpg"/>"
									style="height: 60px; width: 135px"
									alt="Error on loading images" />  -->
							</h4>
						</td>
						<td data-th="Price"><span id="price" class="price">${orderitem.price}</span></td>
						<td data-th="Quantity"><input type="number" name="qty"
							id="quty"> <!--  	<select class="form-control" name="qty" id="quty"> 
							        <option selected="selected">${cartitem.quantity}</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                              		<option value="4">4</option>
                   					<option value="5">5</option>
                    				<option value="6">6</option>
                    				<option value="7">7</option>
                    				<option value="8">8</option>
                    				<option value="9">9</option>
                    				<option value="10">10</option>
                			</select>  --> <span class="status"></span></td>
						<td data-th="Subtotal" class="text-center" id="amount"><span
							id="subtotal" class="subtotal"><i class="fa fa-inr"
								aria-hidden="true"></i>0</span></td>
					<!--   	<td class="actions" data-th=""><a
							href=<c:url value="/deleteCartItem/${cartitem.citemid}"/>
							class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></a></td>  -->

						<c:if test="${cartitem.quantity <1000}"></c:if>

					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr class="visible-xs">
					<td class="text-center"><strong></strong></td>
				</tr>
				<tr>
					<td><a href="productdisplay" class="btn btn-info"><i
							class="fa fa-angle-left"></i> Continue Shopping</a></td>
					<td colspan="2" class="hidden-xs"></td>
					<td class="hidden-xs text-center"><strong>Total:</strong>
					<td class="total"></td>
					<td> <a href="shipment" class="btn btn-success">ship</a>
				<!--  	<c:if test="${n!=0}">
						<td><a href="shipment" id="w3s"
							class="btn btn-success btn-block">Checkout<i
								class="fa fa-angle-right"></i></a></td>
					</c:if> -->
				</tr>
			</tfoot>
		</table>
	</div>
</body>

</html>