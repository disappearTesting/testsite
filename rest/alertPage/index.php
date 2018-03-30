<?php

?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Alert Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
	<style type="text/css">
		body{ font: 14px sans-serif; }
		.container{ width: 350px; padding: 20px; }
	</style>
</head>
<body>
	<div class="container">
		<h1 class="">Alert</h1>
		<div id="alert-form">
			<div class="simple_alert">
				<h4>Simple alert</h4>
				<input type="button" name="input_simple_alert" value="Click" onclick="getSimpleAlert();" />
				<script type="text/javascript">
					function getSimpleAlert() {
						alert("This is a warning message!");
					}
				</script>
			</div>
			<div class="confirm_alert">
				<h4>Confirm alert</h4>
				<input type="button" name="input_confirm_alert" value="Click" onclick="getConfirmAlert();" />
				<script type="text/javascript">
					function getConfirmAlert(){
						var retVal = confirm("Do you want to continue ?");
						if( retVal == true ){
							document.write("User wants to continue!");
							document.close();
							return true;
						} else{
							alert("User does not want to continue!");
						return false;
						}
					}
				</script>
			</div>
			<div class="prompt_alert">
				<h4>Prompt alert</h4>
				<input type="button" name="input_prompt_alert" value="Click" onclick="getPromptAlert();" />
				<script type="text/javascript">
					function getPromptAlert(){
						var retVal = prompt("Enter your name : ", "your name here");
						if( !(retVal == null) ) {
							document.write("You have entered : " + retVal);
							document.close();
							return true;
						} else{
							return false;
						}
					}
				</script>
			</div>
		</div>
	</div>
</body>
</html>