<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Exemple 1 :</h1>
	<ul>
	<?php 
	   $n = 5;
	   for ($i = 0; $i < $n; $i++) {
	       echo "<li>" . $i . "</li>";
	   }
	?>
	</ul>
	
	<hr />
	
	<ul>
	<?php 
	   $n = 5;
	   for ($i = 0; $i < $n; $i++) {
	?>
	<li>
	<?php echo $i ?>
	</li>
	<?php 
	   }
	?>
	</ul>
	
</body>
</html>