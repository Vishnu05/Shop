<!DOCTYPE html>
<html>
	<head>
		<title>Sale Ends</title>
		<style type="text/css">
		body {
			background: #f6f6f6;
		}

		.countdownContainer{
			position: sticky;
			top: 50%;
			left: 50%;
			transform : translateX(-50%) translateY(-50%);
			text-align: center;
			background: #ddd;
			border: 0.1px solid #999;
			border-size:34px;
			padding: 1px;
			box-shadow: 0 0 2px 1px #ccc;
		}

		.info {
			font-size: 50px;
		}
		
		.conainer{
		
		height:120px;
		width:120px;
		}
		</style>
	</head>
	<body>
	
	<div class="container">
		<table class="countdownContainer">
			<tr class="info">
				<td colspan="4">Sales end Countdown</td>
			</tr>
			<tr class="info">
				<td id="days">3</td>
				<td id="hours">8</td>
				<td id="minutes">12</td>
				<td id="seconds">22</td>
			</tr>
			<tr>
				<td>Days</td>
				<td>Hours</td>
				<td>Minutes</td>
				<td>Seconds</td>
			</tr>
		</table> 
		</div>
		<script type="text/javascript">

			function countdown(){
				var now = new Date();
				var eventDate = new Date(2018, 02, 16);

				var currentTiime = now.getTime();
				var eventTime = eventDate.getTime();

				var remTime = eventTime - currentTiime;

				var s = Math.floor(remTime / 1000);
				var m = Math.floor(s / 60);
				var h = Math.floor(m / 60);
				var d = Math.floor(h / 24);

				h %= 24;
				m %= 60;
				s %= 60;

				h = (h < 10) ? "0" + h : h;
				m = (m < 10) ? "0" + m : m;
				s = (s < 10) ? "0" + s : s;

				document.getElementById("days").textContent = d;
				document.getElementById("days").innerText = d;

				document.getElementById("hours").textContent = h;
				document.getElementById("minutes").textContent = m;
				document.getElementById("seconds").textContent = s;

				setTimeout(countdown, 1000);
			}

			countdown();
		</script>
	</body>
</html>