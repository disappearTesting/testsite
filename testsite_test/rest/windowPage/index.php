<?php

?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Window Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
	<style type="text/css">
		body{ font: 14px sans-serif; }
		.container{ width: 350px; padding: 20px; }
	</style>
</head>
<body>
	<div class="container">
		<div class="window">
			<h1>Window</h1>
			<p>
				<a href="/rest/windowPage/main.php" target="_blank" >_blank-window</a>
			</p>
			<p>
				<a href="/rest/windowPage/main.php" target="_self" >_self-window</a>
			</p>
			<p>
				<a id="link" href="/rest/windowPage/main.php" >_new-window</a>
				<script>
					var link = document.getElementById('link')
					link.setAttribute("onclick","popupWin = window.open(this.href,'contacts','location,width=450,height=450,top=0'); popupWin.focus(); return false")
				</script>
			</p>
			<p>
				<a href="/rest/windowPage/main.php" target="iframe_a">_iframe-window</a>
			</p>
			<iframe name="iframe_a" id="iframe_a" height="500" width="500"></iframe>
		</div>
	</div>
</body>
</html>