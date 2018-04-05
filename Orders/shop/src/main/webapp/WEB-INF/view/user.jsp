<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@ include file="header.jsp"%>
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
<!--   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script> -->

<script type="text/javascript">
	var password = document.getElementById("password"), confirm_password = document
			.getElementById("confirm_password");

	function validatePassword() {
		if (password.value != confirm_password.value) {
			confirm_password.setCustomValidity("Passwords Don't Match");
		} else {
			confirm_password.setCustomValidity('');
		}
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
</script>


<style type="text/css">

/*--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
--*/
/* reset */
html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,
	blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,
	em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var,
	b, u, i, dl, dt, dd, ol, nav ul, nav li, fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
	details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
	output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}

article, aside, details, figcaption, figure, footer, header, hgroup,
	menu, nav, section {
	display: block;
}

ol, ul {
	list-style: none;
	margin: 0px;
	padding: 0px;
}

blockquote, q {
	quotes: none;
}

blockquote:before, blockquote:after, q:before, q:after {
	content: '';
	content: none;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}
/* start editing from here */
a {
	text-decoration: none;
}

.txt-rt {
	text-align: right;
} /* text align right */
.txt-lt {
	text-align: left;
} /* text align left */
.txt-center {
	text-align: center;
} /* text align center */
.float-rt {
	float: right;
} /* float right */
.float-lt {
	float: left;
} /* float left */
.clear {
	clear: both;
} /* clear float */
.pos-relative {
	position: relative;
} /* Position Relative */
.pos-absolute {
	position: absolute;
} /* Position Absolute */
.vertical-base {
	vertical-align: baseline;
} /* vertical align baseline */
.vertical-top {
	vertical-align: top;
} /* vertical align top */
nav.vertical ul li {
	display: block;
} /* vertical menu */
nav.horizontal ul li {
	display: inline-block;
} /* horizontal menu */
img {
	max-width: 100%;
}
/*end reset*/
/*--start-body--*/
body {
	background: #227279;
	position: relative;
	font-family: 'Open Sans', sans-serif;
}

body h1 {
	text-align: center;
	margin: 2em 0 0 0;
	color: #fff;
	font-size: 2.5em;
	font-weight: 300;
	text-transform: uppercase;
	letter-spacing: 3px;
}

.main {
	margin: 3% auto 0;
	text-align: center;
	width: 59%;
}
/*-- social-icons --*/
.social_icons {
	text-align: center;
	margin: 1em 0;
}

i.facebook {
	background: url(../images/facebook.png) no-repeat 14px 12px;
	display: block;
	width: 34px;
	height: 27px;
}

i.twitter {
	background: url(../images/twitter.png) no-repeat 7px 11px;
	display: block;
	width: 34px;
	height: 27px;
}

.slide-social {
	display: inline-block;
	overflow: hidden;
	margin: 0 10px 0px 0;
	width: 131px;
	height: 40px;
	background: #2f4982;
	cursor: pointer;
}

.slide-social:nth-child(2) {
	background: #089dd6;
}

.slide-social .button {
	position: absolute;
	margin: 10px 0 0 47px;
	font-size: 0.9em;
	color: #fff;
}

.icon {
	float: left;
	/*-- agileits --*/
	padding-top: 0px;
	width: 25%;
	height: 100%;
	text-align: center;
}

.slide {
	position: relative;
	float: left;
	width: 75%;
	height: 100%;
}

.slide p {
	position: relative;
	top: 10px;
	margin: 0;
	border-left: 1px solid rgba(255, 255, 255, 0.3);
	color: #FFF !important;
	text-align: center;
}
/* Brand Colours */
.facebook {
	background: #3b5998;
}

.twitter {
	background: #00acee;
}
/* Slide Animation */
.slide-social:hover .slide {
	-webkit-transform: translate(101%, 0);
	-moz-transform: translate(101%, 0);
	-ms-transform: translate(101%, 0);
	-o-transform: translate(101%, 0);
	transform: translate(101%, 0);
}

.no-cssanimations .slide {
	display: none; /* hide in IE 8-9 */
}

.touch .slide {
	display: none; /* hide on touch devices */
}
/* Transition */
.slide {
	-webkit-transition: all 200ms ease-in-out;
	-moz-transition: all 200ms ease-in-out;
	-o-transition: all 200ms ease-in-out;
	transition: all 200ms ease-in-out;
}
/* Example Media Queries */
@media only screen and (max-width : 30em) { /* 480px/16px = 30em */
	/*-- w3layouts --*/
	.slide-social {
		width: 100%;
	}
	.slide-social .button {
		position: absolute;
		margin-left: 50%;
	}
}
/*-- social-icons --*/
/*-- /login --*/
.login-top.left {
	float: left;
	width: 55%;
	padding: 2em;
	background: #fff;
}

.login-top.right {
	width: 31.29%;
	float: left;
	padding: 4.8em 2em;
	background: #08538c;
}

.login-bottom {
	margin: 2em 0 3em 0;
}

.login-bottom a {
	float: left;
	color: #fff;
	font-size: 0.95em;
	line-height: 43px;
}

.login-bottom a:hover {
	color: #fff;
	transition: .5s all;
	-webkit-transition: .5s all;
	-moz-transition: .5s all;
	-o-transition: .5s all;
	-ms-transition: .5s all;
	text-decoration: underline;
}

.login-top input[type="text"], .login-top input[type="password"] {
	outline: none;
	font-size: 0.9em;
	color: #999;
	padding: 12px 12px 12px 40px;
	margin: 0;
	width: 89%;
	border: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
	-webkit-appearance: none;
	margin-bottom: 28px;
	font-family: 'Open Sans', sans-serif;
}

.login-top.left input[type="submit"] {
	font-size: 1em;
	color: #fff;
	background: #cb1217;
	outline: none;
	border: none;
	cursor: pointer;
	padding: 15px 10px;
	-webkit-appearance: none;
	width: 100%;
	font-weight: 400;
	transition: .5s all;
	-webkit-transition: .5s all;
	-moz-transition: .5s all;
	-o-transition: .5s all;
	-ms-transition: .5s all;
	text-transform: uppercase;
	margin-top: 1.3em;
}

.login-top.left input[type="submit"]:hover {
	background: #227279;
}

.login-bottom input[type="submit"] {
	font-size: 0.9em;
	color: #fff;
	background: #cb1217;
	outline: none;
	border: none;
	cursor: pointer;
	padding: 12px 10px;
	-webkit-appearance: none;
	width: 35%;
	font-weight: 400;
	transition: .5s all;
	-webkit-transition: .5s all;
	-moz-transition: .5s all;
	-o-transition: .5s all;
	-ms-transition: .5s all;
	text-transform: uppercase;
	float: right;
}

.login-bottom input[type="submit"]:hover {
	background: #227279;
}

.login-top input[type="text"]:focus, .login-top input[type="password"]:focus
	{
	
}

.login-top input.name {
	background: #fff url(../images/1.png) no-repeat 2% 51%;
}

.login-top input.email {
	background: #fff url(../images/3.png) no-repeat 2% 51%;
}

.login-top input.password {
	background: #fff url(../images/2.png) no-repeat 2% 51%;
}

.login-top input.email1 {
	background: #fff url(../images/3.png) no-repeat 4% 51%;
}

.login-top input.password1 {
	background: #fff url(../images/2.png) no-repeat 4% 51%;
}

.login-top input[type="text"]:hover, ..login-top input[type="password"]:hover
	{
	border-bottom-color: rgba(132, 141, 215, 0.52);
}

.login-top.right input[type="text"], .login-top.right input[type="password"]
	{
	outline: none;
	font-size: 0.9em;
	color: #999;
	padding: 12px 12px 12px 60px;
	margin: 0;
	width: 81%;
	border: 1px solid #fff;
	-webkit-appearance: none;
	margin-bottom: 28px;
	font-family: 'Open Sans', sans-serif;
}

.login-top.right h3 {
	text-align: center;
	margin: 0em 0 1em 0;
	color: #fff;
	font-size: 1.5em;
	font-weight: 300;
}
/*--checkbox--*/
.login-top input[type="checkbox"] {
	display: none;
}

.login-top input[type="checkbox"]+label {
	position: relative;
	padding-left: 2em;
	border: none;
	outline: none;
	font-size: 0.95em;
	color: #fff;
	font-weight: 400;
	cursor: pointer;
}

.login-top input[type="checkbox"]+label span:first-child {
	width: 14px;
	height: 14px;
	border: 2px solid #fff;
	position: absolute;
	left: 0;
	top: 2px;
}

.login-top input[type="checkbox"]:checked+label span:first-child:before
	{
	content: "";
	background: url(../images/tick.png) no-repeat;
	position: absolute;
	left: 2px;
	top: 2px;
	font-size: 10px;
	width: 10px;
	height: 10px;
}
/*--//checkbox--*/
.copy-right {
	text-align: center;
	margin: 3em 0 1em 0;
}

.copy-right p {
	color: #fff;
	font-size: 0.9em;
	font-weight: 400;
}

.copy-right p a {
	color: #fff;
}

.copy-right p a:hover {
	text-decoration: underline;
}
/*--/responsive--*/
@media ( max-width :1440px) {
	.main {
		text-align: center;
		width: 66%;
	}
}

@media ( max-width :1366px) {
	.main {
		text-align: center;
		width: 70%;
	}
}

@media ( max-width :1280px) {
	.main {
		text-align: center;
		width: 75%;
	}
	body h1 {
		font-size: 2.3em;
	}
}

@media ( max-width :1028px) {
	body h1 {
		font-size: 2.3em;
	}
	.main {
		text-align: center;
		width: 94%;
	}
}

@media ( max-width :991px) {
	.main {
		text-align: center;
		width: 97%;
	}
	body h1 {
		font-size: 2em;
		margin: 1em 0 0 0;
	}
}

@media ( max-width :800px) {
	.login-top.left {
		float: left;
		width: 88%;
		padding: 2em;
	}
	.login-top.right {
		width: 88%;
		float: left;
		padding: 2em 2em;
	}
	.main {
		text-align: center;
		width: 68%;
	}
	.login-bottom {
		margin: 2em 0 1em 0;
	}
}

@media ( max-width :768px) {
	.main {
		text-align: center;
		width: 85%;
	}
	.login-top.left {
		width: 90%;
	}
	.login-top.right {
		width: 90%;
	}
	body h1 {
		font-size: 1.8em;
		margin: 1em 0 0 0;
	}
	.login-top.right input[type="text"], .login-top.right input[type="password"]
		{
		outline: none;
		font-size: 0.9em;
		color: #999;
		padding: 12px 12px 12px 40px;
		width: 90%;
	}
}

@media ( max-width :640px) {
	.login-top.right input[type="text"], .login-top.right input[type="password"]
		{
		padding: 12px 12px 12px 40px;
		width: 88%;
	}
	.login-top input.password1 {
		background: #fff url(../images/2.png) no-repeat 3% 51%;
	}
	.login-top input.email1 {
		background: #fff url(../images/3.png) no-repeat 3% 51%;
	}
}

@media ( max-width :568px) {
	.login-top.left, .login-top.right {
		width: 86%;
	}
	.login-top input[type="text"], .login-top input[type="password"] {
		width: 86%;
	}
	.login-top.right input[type="text"], .login-top.right input[type="password"]
		{
		width: 86%;
	}
	.copy-right p {
		font-size: 0.85em;
		line-height: 1.8em;
	}
	body h1 {
		font-size: 1.4em;
		margin: 1em 0 0 0;
	}
}

@media ( max-width :480px) {
	.login-top input[type="text"], .login-top input[type="password"],
		.login-top.right input[type="text"], .login-top.right input[type="password"]
		{
		width: 84%;
	}
	.copy-right p {
		font-size: 0.85em;
		line-height: 1.8em;
		padding: 0 2px;
	}
	.login-top.left input[type="submit"] {
		margin-top: 0.5em;
		padding: 13px 10px;
	}
}

@media ( max-width :414px) {
	.main {
		text-align: center;
		width: 96%;
	}
	.login-top.left, .login-top.right {
		width: 83%;
	}
	.copy-right {
		margin: 1em 0 1em 0;
	}
	body h1 {
		font-size: 1.4em;
		margin: 1em 0 0 0;
		letter-spacing: 1px;
	}
	.login-top input.name {
		background: #fff url(../images/1.png) no-repeat 4% 51%;
	}
	.login-top input.email {
		background: #fff url(../images/3.png) no-repeat 4% 51%;
	}
	.login-top input.password {
		background: #fff url(../images/2.png) no-repeat 4% 51%;
	}
}

@media ( max-width :384px) {
	.login-top.left, .login-top.right {
		width: 82%;
	}
	.login-top input[type="text"], .login-top input[type="password"],
		.login-top.right input[type="text"], .login-top.right input[type="password"]
		{
		width: 81%;
		margin-bottom: 10px;
	}
}

@media ( max-width :375px) {
	.login-top.left, .login-top.right {
		width: 81%;
	}
}

@media ( max-width :320px) {
	.login-top.left, .login-top.right {
		width: 81%;
	}
	body h1 {
		font-size: 1.4em;
		margin: 1em 0 0 0;
		letter-spacing: 0px;
	}
	.login-top.left, .login-top.right {
		width: 89%;
		padding: 1em;
	}
	.login-top input[type="text"], .login-top input[type="password"],
		.login-top.right input[type="text"], .login-top.right input[type="password"]
		{
		width: 79%;
		margin-bottom: 10px;
	}
	body h1 {
		font-size: 1.3em;
		margin: 0.7em 0 0 0;
		letter-spacing: 0px;
	}
	.login-top input.email1 {
		background: #fff url(../images/3.png) no-repeat 4% 51%;
	}
	.login-top input.password1 {
		background: #fff url(../images/2.png) no-repeat 4% 51%;
	}
}
/*--//responsive--*/
</style>


</head>

<div class="panel-heading">
	<h3 align="left" class="panel-title">
		<span class="glyphicon glyphicon-user"></span> Administrator DashBoard
	</h3>
	<h3 align="center" class="panel-title">
		<span class="glyphicon glyphicon-home"></span><a href="admin">Home</a>
	</h3>
	<h3 align="right" class="panel-title">
		<span class="glyphicon glyphicon-log-out"></span><a href="#">Logout</a>
	</h3>
</div>

<body>

	 

	<div>
		
		<div class="main">

			<div class="login-top left">
				<div class="social_icons">
					<!-- Facebook -->
					<div class="slide-social w3l">
						<a href="#">
							<div class="button">Facebook</div>
							<div class="facebook icon">
								<i class="facebook"></i>
							</div>
							<div class="facebook slide">
								<p>Facebook</p>
							</div>
							<div class="clear"></div>
						</a>
					</div>
					<!-- Twitter -->
					<div class="slide-social w3l">
						<a href="#">
							<div class="button">Twitter</div>

							<div class="twitter icon">
								<i class="twitter"></i>
							</div>
							<div class="twitter slide">
								<p>Twitter</p>
							</div>
							<div class="clear"></div>
						</a>
					</div>

				</div>

				<form action="adduser" modelAttribute="user" method="POST" name="fm">

					<input id="email" type="text" name="email" class="email"
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
						title="example abc@xxx.com" placeholder="Your Email"
						required="required" />
						
						 <input id="firstname" type="text"
						name="firstname" class="name" pattern="[A-Z][A-za-z\s]{5,30}"
						minlength="6" maxlength="20"
						title="Start with captial letter and altest 6 character"
						placeholder="First Name" required="required" /> 
						
						<input
						id="lastname" type="text" name="lastname" placeholder="Last Name"
						pattern="[a-z]{3,10}[1-9]{1-3}" minlength="2" maxlength="20"
						title="Minmun 2 character long " class="password"
						placeholder="Last Name" required="required" /> 
						
						<input
						id="password" type="password" name="password"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
						class="password" placeholder="Password" required="required" /> <input type="text" name="phonenumber" placeholder="Mobile Number"
						required="required"> <input type="submit" value="SIGN UP">

				</form>
			</div>


			<div class="login-top right">
				<h3>Login</h3>
				  <form id="login-form" action="perform_login" method="post" role="form" style="display: block;">
					
					<input type="text" class="email1 " name="email"
						placeholder="Email" required="required"> 
						
						
						<input type="password"
						class="password1" name="password" placeholder="Password"
						required="required">
						
						
						 <input type="checkbox" id="brand" value="">
					<label for="brand"><span></span> Remember me</label>
					<div class="login-bottom">
					
						<ul>
							<li><a href="#">Forgot password?</a></li>
							<li><input type="submit" value="LOGIN"></li>
							<div class="clear"></div>
						</ul>
					</div>


				</form>

			</div>
			<div class="clear"></div>
		</div>
		<div class="copy-right w3l-agile">
			<p>
				© 2016 Impressive Login & Sign up Forms . All Rights Reserved |
				Design by <a href=" ">W3layouts</a>
			</p>
		</div>


	</div>


</body>

<%
	String password1 = request.getParameter("pass1"); // pass1 is the name of the input tag
	String password2 = request.getParameter("pass2");
	// check if the page has been submitted:
	if (password1 != null && password2 != null) {

		// check if they are equal:
		if (!password1.equals(password2)) {
		}
	}
%>

</html>




