<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Accès au bases de données avec PDO (PHP Data Objects)</h1>
	<?php 
	   $url = "mysql:host=localhost;dbname=Documents;";
	   $db = new PDO($url, "root", "");
	   $res = $db->exec("INSERT into Document VALUES('10', 'POO en PHP', 2019)");
	   if ($res) {
	?>
	<h2>Enregistrement bien effectué</h2>
	<?php 
	   }
	   else {
	?>
	<h2>Erreur SQL</h2>
	<?php 
	   }
	?>
	
</body>
</html>