<?php
	if(!empty($_FILES['uploaded_file'])) {
		$path = "folderToUpload/";
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
	</style>
</head>
<body>
	<div class="container">
		<h1 class="">AutoIT</h1>
		<div id="upload-file-form">
			<h4>Upload File</h4>
			<form enctype="multipart/form-data" action="index.php" method="POST">
				<input type="file" id="button-browse-file" name="uploaded_file"></input>
				<input type="submit" id="button-upload-file" value="Upload"></input>
			</form>
		</div>
		<div id="download-file-form">
			<h4>Download File</h4>
			<label>
				<a id="a-download-file" href="http://testsite.local/rest/filePage/folderToDownload/fileToDownload.txt" download>fileToDownload.txt</a>
			</label>
		</div>
	</div>
</body>
</html>