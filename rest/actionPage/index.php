<?php

?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Action Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
	<link href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" />

	<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	<script src="//cdn.jsdelivr.net/gh/mar10/jquery-ui-contextmenu@v1/jquery.ui-contextmenu.min.js"></script>
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
				<h4>ClickAndHold</h4>
				<p>Press the button and hold 3 sec</p>
				<button id="button-clickAndHold" onmousedown="functionDown();" onmouseup="functionUp();">PressAndHold</button>
				<script>
					var myVar;

					function functionDown() {
						myVar = setTimeout(function(){ alert("AlertClickAndHold"); }, 3000);
					}

					function functionUp() {
						clearTimeout(myVar);
					}
				</script>
			</div>
			<div class="contextMenu-event">
				<h4>ContextMenu</h4>
				<p>Press the right-click on the button</p>
				<div>
					<button class="hasmenu" tabindex="0">ContextMenu</button>
				</div>
			</div>
			<script>
				var CLIPBOARD = "";
				$(function(){
				$(document).contextmenu({
				delegate: ".hasmenu",
				autoFocus: true,
				preventContextMenuForPopup: true,
				preventSelect: true,
				taphold: true,
				menu: [
				{title: "Copy <kbd>Ctrl+C</kbd>", cmd: "copy", uiIcon: "ui-icon-copy"},
				{title: "Paste <kbd>Ctrl+V</kbd>", cmd: "paste", uiIcon: "ui-icon-clipboard", disabled: true },
				{title: "----"},
				{title: "Edit <kbd>[F2]</kbd>", cmd: "edit", uiIcon: "ui-icon-pencil"}
				],
				select: function(event, ui) {
				var $target = ui.target;
				switch(ui.cmd){
				case "copy":
				CLIPBOARD = $target.text();
				break;
				case "paste":
				CLIPBOARD = "";
				break;
				}
				alert("select " + ui.cmd + " on " + $target.text());
				},
				beforeOpen: function(event, ui) {
				var $menu = ui.menu,
				$target = ui.target,
				extraData = ui.extraData;

				$(document)
				.contextmenu("setEntry", "copy", "Copy '" + $target.text() + "'")
				.contextmenu("setEntry", "paste", "Paste" + (CLIPBOARD ? " '" + CLIPBOARD + "'" : ""))
				.contextmenu("enableEntry", "paste", (CLIPBOARD !== ""));
				}
				});

				});
			</script>
		</div>
	</div>
</body>
</html>