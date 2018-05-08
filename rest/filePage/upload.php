<?php
	if(!empty($_FILES['uploaded_file'])) {
		$path = "uploads/";
		$path = $path . basename( $_FILES['uploaded_file']['name']);
		if(move_uploaded_file($_FILES['uploaded_file']['tmp_name'], $path)) {
			echo "The file ".  basename( $_FILES['uploaded_file']['name']). 
			" has been uploaded";
		} else{
			echo "There was an error uploading the file, please try again!";
		}
	}
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>File Page</title>
	<style type="text/css">
		body{ font: 14px sans-serif; }
		.container{ width: 350px; padding: 20px; }
		.upload-file-form > input { display: inline-block; }
	</style>
</head>
<body>
	<div class="container">
		<h1 class="">AutoIT</h1>
		<div id="upload-file-form">
			<h4>Upload File</h4>
			<form enctype="multipart/form-data" action="upload.php" method="POST">
				<input type="file" name="uploaded_file"></input><br />
				<input type="submit" value="Upload"></input>
			</form>
		</div>
	</div>
</body>
</html>