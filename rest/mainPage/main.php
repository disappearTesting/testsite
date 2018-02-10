<?php

?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main Page</title>
	<link rel="stylesheet" href="styleMain.css">
	<style type="text/css">
		
	</style>
</head>
<body>
	<div class="container">
		<header class="header">
			<h2 class=""><a href="http://testsite.local/rest/mainPage/main.php">Main Page</a></h2>
			<nav>
				<ul class="topmenu">
					<li><a href="http://testsite.local/rest/mainPage/main.php">Main Page</a></li>
					<li><a href="#" class="down">Blog</a>
						<ul class="submenu">
							<li><input type="checkbox" name="checkbox-submenu" value="category"><a href="#">Category</a></li>
							<li><input type="checkbox" name="checkbox-submenu" value="author"><a href="#">Author</a></li>
							<li><input type="checkbox" name="checkbox-submenu" value="archive"><a href="#">Archive</a></li>
							<li><input type="checkbox" name="checkbox-submenu" value="tags"><a href="#">Tags</a></li>
						</ul>
					</li>
					<li><a href="" class="down">Portfolio</a>
						<ul class="submenu">
							<li><a href="#">Category</a></li>
							<li><a href="#">Author</a></li>
							<li><a href="#">Archive</a></li>
							<li><a href="#">Tags</a></li>
						</ul>
					</li>
					<li><a href="#">Contact</a></li>
				</ul>
			</nav>
		</header>
	</div>
</body>
</html>