<?php

?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Post Page</title>
	<link rel="stylesheet" href="styleIndex.css">
	<style type="text/css">
		
	</style>
</head>
<body>
	<div class="container">
		<header class="header">
			<h1 class="">CRUD Post</h1>
			<a href="create.php" class="a-button-create">Create</a>
		</header>
		<content>
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Email Address</th>
						<th>Mobile Number</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<?php
						include 'config.php';
							$pdo = Database::connect();
							$sql = 'SELECT * FROM customers ORDER BY id DESC';
						foreach ($pdo->query($sql) as $row) {
							echo '<tr>';
							echo '<td>'. $row['name'] . '</td>';
							echo '<td>'. $row['email'] . '</td>';
							echo '<td>'. $row['mobile'] . '</td>';
							echo '<td><a class="btn" href="read.php?id='.$row['id'].'">Read</a></td>';
							echo '</tr>';
						}
						Database::disconnect();
					?>
				</tbody>
			</table>
		</content>
	</div>
</body>
</html>