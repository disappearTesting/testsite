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
			<h1 class="">Main Page</h1>
			<nav>
				<ul class="topmenu">
					<li><a href="http://testsite.local/rest/mainPage/main.php">Main Page</a></li>
					<li class="topmenu-dropdown"><a href="">Dropdown</a>
						<ul class="submenu-dropdown">
							<li><a href="">Test</a></li>
							<li><a href="">Test</a></li>
							<li><a href="">Test</a></li>
						</ul>
					</li>
					<li class="topmenu-checkbox"><a href="">Checkbox</a>
						<ul class="submenu-checkbox">
							<li>
								<input type="checkbox" id="option_1" name="checkbox" value="option_1">
								<label for="option_1">Option 1</label>
							</li>
							<li>
								<input type="checkbox" id="option_2" name="checkbox" value="option_2">
								<label for="option_2">Option 2</label>
							</li>
							<li>
								<input type="checkbox" id="option_3" name="checkbox" value="option_3">
								<label for="option_3">Option 3</label>
							</li>
						</ul>
					</li>
					<li class="topmenu-radio-button"><a href="">Radio Button</a>
						<ul class="submenu-radio-button">
							<li>
								<input type="radio" id="radio_button_1" name="radio-button" value=">radio_button_1">
								<label for="radio_button_1">Radio button 1</label>
							</li>
							<li>
								<input type="radio" id="radio_button_2" name="radio-button" value=">radio_button_2">
								<label for="radio_button_2">Radio button 2</label>
							</li>
							<li>
								<input type="radio" id="radio_button_3" name="radio-button" value=">radio_button_3">
								<label for="radio_button_3">Radio button 3</label>
							</li>
						</ul>
					</li>
				</ul>
			</nav>
		</header>
	</div>
</body>
</html>