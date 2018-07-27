<?php

?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Slider Page</title>
	<style type="text/css">
		body{ font: 14px sans-serif; }
		.container{ width: 350px; padding: 20px; }
	</style>
	
	<!-- slider-example -->
    <link href="slider-example/bootstrap.min.css" rel="stylesheet">
    <link href="slider-example/bootstrap-slider.css" rel="stylesheet">
    <!-- Hightlight.js Theme Styles -->
    <link href="slider-example/highlightjs-github-theme.css" rel="stylesheet">
	<script type="text/javascript" src="slider-example/modernizr.js.Без названия"></script>
	<script type="text/javascript" src="slider-example/jquery.min.js.Без названия"></script>
	<script type="text/javascript" src="slider-example/bootstrap-slider.js.Без названия"></script>
	<script type="text/javascript" src="slider-example/highlight.min.js.Без названия"></script>
	<script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
	<div class="container">
		<div class="slider-event">
			<h1>Sliders</h1>
			<div class="slider-example-6">
				<h4>Example 1</h4>
				<p>Make DragAndDrop action</p>
				<input id="ex6" type="text" data-slider-min="-5" data-slider-max="20" data-slider-step="1" data-slider-value="3"/>
				<span id="ex6CurrentSliderValLabel">Current Slider Value: <span id="ex6SliderVal">3</span></span>
				<script>
					$("#ex6").slider();
					$("#ex6").on("slide", function(slideEvt) {
						$("#ex6SliderVal").text(slideEvt.value);
					});
				</script>
			</div>
			<div class="slider-example-6">
				<h4>Example 2</h4>
				<p>Make DragAndDrop action</p>
				<input id="ex8" data-slider-id='ex1Slider' type="text" data-slider-min="0" data-slider-max="20" data-slider-step="1" data-slider-value="14"/>
				<script>
					$("#ex8").slider({
						tooltip: 'always'
					});
				</script>
			</div>
			<div class="slider-example-6">
				<h4>Example 3</h4>
				<p>Make DragAndDrop action</p>
				<span id="ex18-label-1" class="hidden">Example slider label</span>
				<input id="ex19" type="text"
					  data-provide="slider"
					  data-slider-ticks="[1, 2, 3]"
					  data-slider-ticks-labels='["short", "medium", "long"]'
					  data-slider-min="1"
					  data-slider-max="3"
					  data-slider-step="1"
					  data-slider-value="3"
					  data-slider-tooltip="hide" />
			</div>
		</div>
	</div>
</body>
</html>