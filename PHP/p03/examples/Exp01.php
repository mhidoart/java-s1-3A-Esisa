<?php 
    include '../dao/DocumentDaoFile.php';
?>
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
        $dao = new DocumentDaoFile("C:/data/php/A/biblio.txt");
        $docs = $dao->select();
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