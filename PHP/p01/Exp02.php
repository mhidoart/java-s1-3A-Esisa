<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Exemple 2 :</h1>
	<?php 
	   $n = 20;
	   echo "Le type de $n : " . gettype($n) . "<br />";

	   $n = 20.5;
	   echo "Le type de $n : " . gettype($n) . "<br />";

	   $n = "une chaine de caractères";
	   echo "Le type de $n : " . gettype($n) . "<br />";

	   $n = true;
	   echo "Le type de $n : " . gettype($n) . "<br />";
	   
	?>	
</body>
</html>