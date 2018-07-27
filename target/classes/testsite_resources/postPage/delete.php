<?php
    require 'config.php';
    $id = 0;
     
    if ( !empty($_GET['id'])) {
        $id = $_REQUEST['id'];
    }
     
    if ( !empty($_POST)) {
        // keep track post values
        $id = $_POST['id'];
         
        // delete data
        $pdo = Database::connect();
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $sql = "DELETE FROM customers  WHERE id = ?";
        $q = $pdo->prepare($sql);
        $q->execute(array($id));
        Database::disconnect();
        header("Location: index.php");
         
    }
?>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<title>Delete Page</title>
	<link rel="stylesheet" href="styleDelete.css">
	<style type="text/css">
		
	</style>
</head>
 
<body>
	<div class="container">
		<header class="header">
			<h1>Delete a Customer</h1>
		</header>
		<content>
			<form class="form-horizontal" action="delete.php" method="post">
				<input type="hidden" name="id" value="<?php echo $id;?>"/>
				<p class="alert alert-error">Are you sure to delete ?</p>
				<div class="form-actions">
					<button type="submit" class="btn btn-danger">Yes</button>
					<a class="a-button-no" href="index.php">No</a>
				</div>
			</form>
		</content>
	</div> <!-- /container -->
  </body>
</html>