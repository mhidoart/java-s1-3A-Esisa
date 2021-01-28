<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<?php 
	   $id = $_POST["id"];
	   $title = $_POST["title"];
	   $yearPublished = $_POST["yearPublished"];
	   $price = $_POST["price"];
    ?>
    <h1>Document bien recupéré</h1>
    <table border="1" style="border-collapse: collapse;width: 50%;">
    	<tr><td>Identificateur : </td><td><?= $id ?></td></tr>
    	<tr><td>Titre : </td><td><?= $title ?></td></tr>
    	<tr><td>Année d'édition : </td><td><?= $yearPublished ?></td></tr>
    	<tr><td>Prix : </td><td><?= $price ?></td></tr>
    </table>
    <?php 
        $f = fopen("C:/data/php/A/biblio.txt", "a");
        fputs($f, "$id, $title, $yearPublished, $price\r\n");
        fclose($f);
    ?>
</body>
</html>