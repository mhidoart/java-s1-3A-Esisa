<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Liste des documents</h1>
    <table border="1" style="border-collapse: collapse;width: 100%;">
    <?php 
        foreach ($docs as $doc) {
    ?>
    		<tr>
        		<td style="padding: 10px;"><?= $doc->getIsbn() ?></td>
        		<td style="padding: 10px;"><?= $doc->getTitle() ?></td>
        		<td style="padding: 10px;"><?= $doc->getYearPublished() ?></td>
    		</tr>
    <?php 
        }
    ?>
    </table>
</body>
</html>