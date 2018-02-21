<?php
     
    require 'config.php';
 
    if ( !empty($_POST)) {
        // keep track validation errors
        $nameError = null;
        $emailError = null;
        $mobileError = null;
         
        // keep track post values
        $name = $_POST['name'];
        $email = $_POST['email'];
        $mobile = $_POST['mobile'];
         
        // validate input
        $valid = true;
        if (empty($name)) {
            $nameError = 'Please enter Name';
            $valid = false;
        }
         
        if (empty($email)) {
            $emailError = 'Please enter Email Address';
            $valid = false;
        } else if ( !filter_var($email,FILTER_VALIDATE_EMAIL) ) {
            $emailError = 'Please enter a valid Email Address';
            $valid = false;
        }
         
        if (empty($mobile)) {
            $mobileError = 'Please enter Mobile Number';
            $valid = false;
        } else if(array_key_exists('mobile', $_POST)) {
			if(!preg_match('/^\+380\d{3}\d{2}\d{2}\d{2}$/', $_POST['mobile'])) {
			  $mobileError = 'Please enter a valid Mobile Number';
			  $valid = false;
			}
		}
         
        // insert data
        if ($valid) {
            $pdo = Database::connect();
            $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $sql = "INSERT INTO customers (name,email,mobile) values(?, ?, ?)";
            $q = $pdo->prepare($sql);
            $q->execute(array($name,$email,$mobile));
            Database::disconnect();
            header("Location: index.php");
        }
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<title>Create Page</title>
	<link rel="stylesheet" href="styleCreate.css">
	<link rel="stylesheet" href="styles/kendo.common.min.css" />
    <link rel="stylesheet" href="styles/kendo.default.min.css" />
    <link rel="stylesheet" href="styles/kendo.default.mobile.min.css" />

    <script src="js/jquery.min.js"></script>
    <script src="js/kendo.all.min.js"></script>
	<script type="text/javascript">
		function startTime()
		{
		var tm=new Date();
		var h=tm.getHours();
		var m=tm.getMinutes();
		var s=tm.getSeconds();
		m=checkTime(m);
		s=checkTime(s);
		document.getElementById('txt').innerHTML=h+":"+m+":"+s;
		t=setTimeout('startTime()',500);
		}
		function checkTime(i)
		{
		if (i<10)
		{
		i="0" + i;
		}
		return i;
		}
	</script>
	<script>
		$(function(){
		$('#datetime12').combodate();  
		});
	</script>
</head>
<body  onload="startTime()">
    <div class="container">
		<header class="header">
			<h1>Create a Customer</h1>
			<div class="time">
				<p id="txt"> </p>
			</div>
		</header>
		<content>
			<form class="form-horizontal" action="create.php" method="post">
				<div class="control-group <?php echo !empty($nameError)?'error':'';?>">
					<label class="control-label">Name</label>
					<div class="controls">
						<input name="name" type="text" placeholder="Name" value="<?php echo !empty($name)?$name:'';?>">
						<?php if (!empty($nameError)): ?>
						<span class="help-inline"><?php echo $nameError;?></span>
						<?php endif; ?>
					</div>
				</div>
				<div class="control-group <?php echo !empty($emailError)?'error':'';?>">
					<label class="control-label">Email Address</label>
					<div class="controls">
						<input name="email" type="text" placeholder="Email Address" value="<?php echo !empty($email)?$email:'';?>">
						<?php if (!empty($emailError)): ?>
						<span class="help-inline"><?php echo $emailError;?></span>
						<?php endif;?>
					</div>
				</div>
				<div class="control-group <?php echo !empty($mobileError)?'error':'';?>">
					<label class="control-label">Mobile Number</label>
					<div class="controls">
						<input name="mobile" type="text" placeholder="Mobile Number" value="<?php echo !empty($mobile)?$mobile:'';?>">
						<?php if (!empty($mobileError)): ?>
						<span class="help-inline"><?php echo $mobileError;?></span>
						<?php endif;?>
					</div>
				</div>
				<div class="form-actions">
					<button type="submit" class="button-create">Create</button>
					<a class="a-button-back" href="index.php">Back</a>
				</div>
			</form>
		</content>
	</div>
  </body>
</html>