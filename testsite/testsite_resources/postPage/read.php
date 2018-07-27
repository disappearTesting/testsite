<?php
    require 'config.php';
    $id = null;
    if ( !empty($_GET['id'])) {
        $id = $_REQUEST['id'];
    }
     
    if ( null==$id ) {
        header("Location: index.php");
    } else {
        $pdo = Database::connect();
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $sql = "SELECT * FROM customers where id = ?";
        $q = $pdo->prepare($sql);
        $q->execute(array($id));
        $data = $q->fetch(PDO::FETCH_ASSOC);
        Database::disconnect();
    }
?>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<title>Read Page</title>
	<link rel="stylesheet" href="styleRead.css">
	<style type="text/css">
		
	</style>
</head>
 
<body>
	<div class="container">
		<header class="header">
			<h1>Read a Customer</h1>
		</header>
		<content>
			<form class="form-horizontal" >
				<div class="control-group">
					<label class="control-label">Name</label>
					<div class="controls">
						<label class="checkbox">
							<?php echo $data['name'];?>
						</label>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Email Address</label>
					<div class="controls">
						<label class="checkbox">
							<?php echo $data['email'];?>
						</label>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Mobile Number</label>
					<div class="controls">
						<label class="checkbox">
							<?php echo $data['mobile'];?>
						</label>
					</div>
				</div>
				<div class="form-actions">
					<a class="a-button-back" href="index.php">Back</a>
				</div>
			</form>
		</content>
	</div> <!-- /container -->
</body>
</html>