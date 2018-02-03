<?php
ob_start();
session_start();
require_once 'config.php';

// if session is not set this will redirect to login page
if( !isset($_SESSION['user']) ) {
header("Location: login.php");
exit;
}
// select loggedin users detail
$res=mysql_query("SELECT * FROM users WHERE userId=".$_SESSION['user']);
$userRow=mysql_fetch_array($res);
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome - <?php echo $userRow['userEmail']; ?></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
	<style type="text/css">
		body{ font: 14px sans-serif; }
		.container{ width: 350px; padding: 20px; }
	</style>
</head>
<body>
<div class="container">
		<p><a href="#">
		<span class="glyphicon glyphicon-user"></span>&nbsp;Hi' <?php echo $userRow['userEmail']; ?>&nbsp;<span class="caret"></span></a></p>
		<p><a href="logout.php?logout"><span class="glyphicon glyphicon-log-out"></span>&nbsp;Sign Out</a></p>
</div>
<script src="assets/jquery-1.11.3-jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
<?php ob_end_flush(); ?>