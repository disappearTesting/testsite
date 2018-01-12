<html>
<head>
	<h3>Результат загрузки файла</h3>
</head>
<body>
<?php

if (isset($_FILES['uploadfile'])) {
	// Каталог, в который мы будем принимать файл:
	$uploaddir = './uploadFiles/';
	$uploadfile = $uploaddir.basename($_FILES['uploadfile']['name']);

	// Копируем файл из каталога для временного хранения файлов:
if (copy($_FILES['uploadfile']['tmp_name'], $uploadfile)) {
	echo "<h3>Файл успешно загружен на сервер</h3>";
	} else { 
		echo "<h3>Ошибка! Не удалось загрузить файл на сервер!</h3>";
		exit;
	}
} else {
	echo "<h3>Ошибка! Файл не передан!</h3>"; 
	exit;
	}
?>
</body>
</html>
