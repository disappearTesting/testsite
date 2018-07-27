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
	
	<!-- resizearea -->
	<link href="resize/styleResize.css" rel="stylesheet" type="text/css">
	<script src="resize/jquery-resizable.js"></script>
	
	<!-- select-multiple -->
	
	<!-- sort-box -->
	<link rel="stylesheet" href="sort/jquery-ui.css">
	<link rel="stylesheet" href="sort/style.css">
	<script src="sort/jquery-ui.js.Без названия"></script>
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
			<div class="textarea-event">
				<h4>TextArea</h4>
				<textarea id="input-textarea" rows="4" cols="50"></textarea>
				<p id="demo"></p>
			</div>
			<div class="box">
				<h4>ResizeArea</h4>
				<p id="box-text">Curabitur aliquet quam id dui posuere blandit. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a. Pellentesque in ipsum id orci porta dapibus. Quisque velit nisi, pretium ut lacinia in, elementum id enim. Curabitur non nulla sit amet nisl tempus convallis quis ac lectus. Curabitur aliquet quam id dui posuere blandit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Vivamus magna justo, lacinia eget consectetur sed, convallis at tellus.</p>
				<div class="win-size-grip"></div>
			<script>    
				$(".box").resizable({
					handleSelector: "> .win-size-grip",
					onDragStart: function (e, $el, opt) {
						$el.css("cursor", "nwse-resize");
					},
					onDragStop: function (e, $el, opt) {
						$el.css("cursor", "");
					}
				});        
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
			
			<div class="select-multiple-event">
				<div class="select-box">
					<h4>SelectBox</h4>
					<p>Select elements, individually or in a group.</p>
					<form action="#" method="post" id="demoForm" class="demoForm">
						<p>
							<select name="demoSel[]" id="demoSel" size="8" width="200" multiple style="width:175px">
								<option value="option_1" disabled>Option 1</option>
								<option value="option_2">Option 2</option>
								<option value="option_3">Option 3</option>
								<option value="option_4">Option 4</option>
								<option value="option_5">Option 5</option>
								<option value="option_6">Option 6</option>
							</select>
							<input id="button-submit-select-box" type="submit" value="Submit" />
							<textarea name="display" id="display" placeholder="view select list value(s) onchange" cols="20" rows="4" readonly></textarea>
						</p>
					</form>
				</div>
				<script>
					// arguments: reference to select list, callback function (optional)
					function getSelectedOptions(sel, fn) {
						var opts = [], opt;
						
						// loop through options in select list
						for (var i=0, len=sel.options.length; i<len; i++) {
							opt = sel.options[i];
							
							// check if selected
							if ( opt.selected ) {
								// add to array of option elements to return from this function
								opts.push(opt);
								
								// invoke optional callback function if provided
								if (fn) {
									fn(opt);
								}
							}
						}
						
						// return array containing references to selected option elements
						return opts;
					}
				</script>
				<script>
					// example callback function (selected options passed one by one)
					function callback(opt) {
						// display in textarea for this example
						var display = document.getElementById('display');
						display.innerHTML += opt.value + ', ';

						// can access properties of opt, such as...
						//alert( opt.value )
						//alert( opt.text )
						//alert( opt.form )
					}
				</script>
				<script>
					// anonymous function onchange for select list with id demoSel
					document.getElementById('demoSel').onchange = function(e) {
						// get reference to display textarea
						var display = document.getElementById('display');
						display.innerHTML = ''; // reset
						
						// callback fn handles selected options
						getSelectedOptions(this, callback);
						
						// remove ', ' at end of string
						var str = display.innerHTML.slice(0, -2);
						display.innerHTML = str;
					};

					document.getElementById('demoForm').onsubmit = function(e) {
						// reference to select list using this keyword and form elements collection
						// no callback function used this time
						var opts = getSelectedOptions( this.elements['demoSel[]'] );
						
						alert( 'Selected is: ' + opts.length ); //  number of selected options
						
						return false; // don't return online form
					};
				</script>
			</div>
			<div class="sort-box">
				<h4>SortBox</h4>
				<p>Reorder elements in a list using the mouse.</p>
				<ul id="sortable">
				  <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 1</li>
				  <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 2</li>
				  <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 3</li>
				  <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 4</li>
				  <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 5</li>
				  <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 6</li>
				  <li class="ui-state-default"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>Item 7</li>
				</ul>
				<script>
				  $( function() {
					$( "#sortable" ).sortable();
					$( "#sortable" ).disableSelection();
				  } );
				</script>
			</div>
			<div class="image-box">
				<h4>ImageBox</h4>
				<figure class="fig1">
					<figcaption>Save image from URL</figcaption>
					<img id="img-fig1" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpJEu-MpZMbIw1ttUBKceo0StB3zax9TjY6eoErmnGWoCGM2I">
				</figure>
				<figure class="fig2">
					<figcaption>Save image from local repo</figcaption>
					<img id="img-fig2" src="images/test.png">
				</figure>
			</div>
		</div>
	</div>
</body>
</html>