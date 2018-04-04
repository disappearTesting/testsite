<?php

?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Action Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
	<style type="text/css">
		body{ font: 14px sans-serif; }
		.container{ width: 350px; padding: 20px; }
	</style>
</head>
<body>
	<div class="container">
		<h1 class="">Actions</h1>
		<div id="action-form">
			<div class="clickAndHold_event">
				<h4>clickAndHold</h4>
				<p>Press the button and hold 3 sec</p>
				<button onmousedown="functionDown();" onmouseup="functionUp();">PressAndHold</button>
				<script>
					function functionDown() {
						var timerId = setTimeout(function() { alert('Hello World') }, 3000);
					}
					
					function functionUp() {
						setTimeout(function() { clearInterval(timerId); }
				</script>
			</div>
			
		</div>
	</div>
</body>
</html>