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
	
	<!-- contextMenu-hard -->
	<link href="simple-contextMenu/css.txt" rel="stylesheet" type="text/css">
    <link href="simple-contextMenu/jquery.css" rel="stylesheet" type="text/css">
    <script src="simple-contextMenu/jquery_003.txt"></script>
    <script src="simple-contextMenu/jquery_002.txt" type="text/javascript"></script>
    <script src="simple-contextMenu/jquery.txt" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<h1 class="">Actions</h1>
		<div id="action-form">
			<div class="clickAndHold_event">
				<h4>ClickAndHold</h4>
				<p>Press the button and hold 3 sec</p>
				<button id="button-clickAndHold" onmousedown="functionDown();" onmouseup="functionUp();" >PressAndHold</button>
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
				<div class="contextMenu-hard">
					<div>
						<p>Hard. Press the right-click on the button</p>
						<button id="button-hard-contextMenu" tabindex="0">ContextMenu</button>
					</div>
					<script>
						$(function(){
							$.contextMenu({
								selector: '#button-hard-contextMenu', 
								items: {
								// <input type="text">
								name: {
								name: "Text", 
								type: 'text', 
								value: "Hello World",
								events: {
								keyup: function(e) {
								// add some fancy key handling here?
								window.console && console.log('key: '+ e.keyCode); 
								}
								}
								},
								sep1: "---------",
								// <input type="checkbox">
								yesno: {
								name: "Boolean",
								id: "chckb",
								type: "checkbox",
								selected: true
								},
								sep2: "---------",
								// <input type="radio">
								radio1: {
								name: "Radio1", 
								type: 'radio', 
								radio: 'radio', 
								value: '1',
								disabled: true
								},
								radio2: {
								name: "Radio2", 
								type: 'radio', 
								radio: 'radio', 
								value: '2', 
								selected: true
								},
								radio3: {
								name: "Radio3", 
								type: 'radio', 
								radio: 'radio', 
								value: '3'
								},
								radio4: {
								name: "Radio3", 
								type: 'radio', 
								radio: 'radio', 
								value: '4'
								},
								sep3: "---------",
								// <select>
								select: {
								name: "Select", 
								type: 'select', 
								options: {1: 'one', 2: 'two', 3: 'three'}, 
								selected: 2
								},
								// <textarea>
								area2: {
								name: "Textarea", 
								type: 'textarea', 
								value: "Hello World"
								}
								},
								events: {
								show: function(opt) {
								// this is the trigger element
								var $this = this;
								// import states from data store 
								$.contextMenu.setInputValues(opt, $this.data());
								// this basically fills the input commands from an object
								// like {name: "foo", yesno: true, radio: "3", &hellip;}
								}, 
								hide: function(opt) {
								// this is the trigger element
								var $this = this;
								// export states to data store
								$.contextMenu.getInputValues(opt, $this.data());
								// this basically dumps the input commands' values to an object
								// like {name: "foo", yesno: true, radio: "3", &hellip;}
								}
								}
							});
						});
					</script>
				</div>
				<div class="contextMenu-simple">
					<div>
						<p>Simple. Press the right-click on the button</p>
						<button id="button-simple-contextMenu" >ContextMenu</button>
					</div>
					<script type="text/javascript" class="showcase">
						$(function(){
							$.contextMenu({
								selector: '#button-simple-contextMenu', 
								callback: function(key, options) {
								var m = "clicked: " + key;
								window.console && console.log(m) || alert(m); 
								},
								items: {
								"edit": {"name": "Edit", "icon": "edit"},
								"cut": {"name": "Cut", "icon": "cut"},
								"sep1": "---------",
								"quit": {"name": "Quit", "icon": "quit"},
								"sep2": "---------",
								"fold1": {
								"name": "Sub group", 
								"items": {
								"fold1-key1": {"name": "Foo bar"},
								"fold2": {
								"name": "Sub group 2", 
								"items": {
								"fold2-key1": {"name": "alpha"},
								"fold2-key2": {"name": "bravo"},
								"fold2-key3": {"name": "charlie"}
								}
								},
								"fold1-key3": {"name": "delta"}
								}
								},
								"fold1a": {
								"name": "Other group", 
								"items": {
								"fold1a-key1": {"name": "echo"},
								"fold1a-key2": {"name": "foxtrot"},
								"fold1a-key3": {"name": "golf"}
								}
								}
								}
							});
							});
					</script>
				</div>
			</div>
		</div>
	</div>
</body>
</html>