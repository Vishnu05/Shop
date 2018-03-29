
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body style="height: 1500px">

	<div class="container-fluid">
		<br>
		<h3>Sticky Navbar</h3>
		<p>A sticky navigation bar stays fixed at the top of the page when
			you scroll past it.</p>
		<p>
			Scroll this page to see the effect. <strong>Note:</strong> sticky-top
			does not work in IE11 and earlier.
		</p>
	</div>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
		<a class="navbar-brand" href="#">E-Commerce</a>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="productdisplay">Products</a></li>
			

			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>

			


			<li><a class="left"></a></li>


			<li>
				<form class="form-inline" action="/action_page.php">
					<input class="form-control" type="text" placeholder="Search">
					<button class="btn btn-success" type="submit">Search</button>
				</form>
			</li>
			
			<li class="nav-item" class="navbar navbar-left" ><a class="nav-link" href="user">Sign up</a></li>

			<li  class="navbar navbar-left"><a class="nav-link" href="login">Login</a></li>

		</ul>
		
		<ul class="navbar navbar-left">
		
		
		
		</ul>
		
	</nav>

	<div class="container-fluid">
		<br>

	</div>

</body>
</html>


