<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Liste des documents</h1>
    <table border="1" style="border-collapse: collapse;width: 50%;">
    <?php 
        $f = fopen("C:/data/php/A/biblio.txt", "r");
        $row = fgets($f);
        while ($row) {
            $t = explode(",", $row);
    ?>
    		<tr>
        		<?php foreach ($t as $e) { ?>
        		<td style="padding: 10px;"><?= $e ?></td>
        		<?php } ?>
    		</tr>
    <?php 
            $row = fgets($f);
        }
        fclose($f);
    ?>
    </table>
</body>
</html>