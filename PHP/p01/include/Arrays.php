<?php

function printArray01($t) {
    $n = count($t);
    echo "Nombre d'elements : $n";
    echo "<table border='1' style='border-collapse: collapse;'>";
    for ($i = 0; $i < $n; $i++) {
        echo "<tr><td style='padding: 5px;'>" . $t[$i] . "</td></tr>";
    }
    echo "</table>";
}

function printArray02($t) {
    $e = each($t);
    echo "<table border='1' style='border-collapse: collapse;'>";
    while ($e) {
        echo "<tr><td style='padding: 5px;'>" . $e[0] . "</td>";
        echo "<td style='padding: 5px;'>" . $e[1] . "</td></tr>";
        echo "<tr><td style='padding: 5px;'>" . $e["key"] . "</td>";
        echo "<td style='padding: 5px;'>" . $e["value"] . "</td></tr>";
        
        $e = each($t);
    }
    echo "</table>";
}

function printArray3($t) { // une matrice ou tableau d'enregistrement!
    echo "<table border='1' style='border-collapse: collapse;'>";
    // Afficher les titres
    $doc = each($t); // r�cup�rer le premier �l�ment qui est un tableau
    $e = each($doc[1]); // R�cup�rer le premier �l�ment du tableau
    echo "<tr>";
    while ($e) {
        echo "<th>" . $e["key"] . "</th>";
        $e = each($doc[1]);
    }
    echo "</tr>";
    // Afficher les donn�es
    foreach ($t as $doc) {
        echo "<tr>";
        foreach ($doc as $v) {
            echo "<td>" . $v . "</td>";
        }
        echo "</tr>";
    }
    echo "</table>";
}