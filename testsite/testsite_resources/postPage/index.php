<?php

?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Index Page</title>
	<link rel="stylesheet" href="styleIndex.css">
	<style type="text/css">
		
	</style>
</head>
<body>
	<div class="container">
		<header class="header">
			<h1>Table of Customers</h1>
			<p><a href="create.php" class="a-button-create">Create</a></p>
		</header>
		<content>
			<form class="form-post">
				<table>
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
								echo '<td width=250>';
                                echo '<a class="a-button-read" href="read.php?id='.$row['id'].'">Read</a>';
                                echo ' ';
                                echo '<a class="a-button-update" href="update.php?id='.$row['id'].'">Update</a>';
                                echo ' ';
                                echo '<a class="a-button-delete" href="delete.php?id='.$row['id'].'">Delete</a>';
                                echo '</td>';
								echo '</tr>';
							}
							Database::disconnect();
						?>
					</tbody>
				</table>
			</form>
		</content>
	</div>
</body>
</html>