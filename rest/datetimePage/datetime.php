<?php

?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <title>Datetime Page</title>
	<link rel="stylesheet" href="styleDatetime.css">
	<link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.1.221/styles/kendo.common.min.css">
	<link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.1.221/styles/kendo.rtl.min.css">
	<link rel="stylesheet" href="https://kendo.cdn.telerik.com/2018.1.221/styles/kendo.default.min.css">

    <script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
    <script src="https://kendo.cdn.telerik.com/2018.1.221/js/kendo.all.min.js"></script>

	<script src="js/jquery.min.js"></script>
	<script src="js/kendo.all.min.js"></script>
	<script src="https://kendo.cdn.telerik.com/2018.1.221/js/angular.min.js"></script>
	<script src="https://kendo.cdn.telerik.com/2018.1.221/js/jszip.min.js"></script>
	<script>
		// Basic
		$(document).ready(function () {
		// create DateTimePicker from input HTML element
		$("#datetimepicker").kendoDateTimePicker({
		value: new Date(),
		dateInput: true
		});
		});
	</script>
	<script>
		// Range selection
		$(document).ready(function() {
			function startChange() {
				var startDate = start.value(),
				endDate = end.value();

				if (startDate) {
					startDate = new Date(startDate);
					startDate.setDate(startDate.getDate());
					end.min(startDate);
				} else if (endDate) {
					start.max(new Date(endDate));
				} else {
					endDate = new Date();
					start.max(endDate);
					end.min(endDate);
				}
			}

			function endChange() {
				var endDate = end.value(),
				startDate = start.value();

				if (endDate) {
					endDate = new Date(endDate);
					endDate.setDate(endDate.getDate());
					start.max(endDate);
				} else if (startDate) {
					end.min(new Date(startDate));
				} else {
					endDate = new Date();
					start.max(endDate);
					end.min(endDate);
				}
			}

			var today = kendo.date.today();

			var start = $("#start").kendoDateTimePicker({
				value: today,
				change: startChange,
				parseFormats: ["MM/dd/yyyy"]
			}).data("kendoDateTimePicker");

			var end = $("#end").kendoDateTimePicker({
				value: today,
				change: endChange,
				parseFormats: ["MM/dd/yyyy"]
			}).data("kendoDateTimePicker");

			start.max(end.value());
			end.min(start.value());
		});
	</script>
</head>
<body>
	<div class="container">
		<header class="header">
			<h1>Datetimepicker</h1>
			<div class="time">
				<p id="txt"> </p>
			</div>
		</header>
		<content>
			<form class="datetime-basic">
				<h4>Basic usage</h4>
				<div class="demo-section k-content">
					<input id="datetimepicker" style="width: 50%;" />
				</div>
			</form>
			<form class="datetime-range-selection">
				<h4>Range selection</h4>
				<div class="demo-section k-content">
					<p>Start date</p>
					<input id="start" style="width: 50%;" />
					<p>End date</p>
					<input id="end" style="width: 50%;" />
				</div>
			</form>
		</content>
		</div>
	</div>
</body>
</html>

