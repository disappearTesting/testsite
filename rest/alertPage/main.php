<?php

?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
	<style type="text/css">
		body{ font: 14px sans-serif; }
		.container{ width: 350px; padding: 20px; }
	</style>
</head>
<body>
	<div class="container">
		<h1>Hello World!</h1>
		<div class="links">
			<p>
				<a href="/rest/alertPage/home.php" target="_blank" >_blank-window</a>
			</p>
			<p>
				<a href="/rest/alertPage/home.php" target="_self" >_self-window</a>
			</p>
			<p>
				<a id="link" href="/rest/alertPage/home.php" >_new-window</a>
				<script>
					var link = document.getElementById('link')
					link.setAttribute("onclick","popupWin = window.open(this.href,'contacts','location,width=350,height=350,top=0'); popupWin.focus(); return false")
				</script>
			</p>
			<p>
				<a href="/rest/alertPage/home.php" target="iframe_b">_iframe-window</a>
			</p>
			<iframe name="iframe_b" height="350" width="360"></iframe>
		</div>
	</div>
</body>
</html>