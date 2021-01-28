<?php
function exp01() {
    $t = array("HTML", "CSS", "JavaScript", "PHP", "VB", 20, 3.14);
    for ($i = 0; $i < count($t); $i++) {
        echo $t[$i] . "<br />";
    }
}

function exp02() {
    $t = array("HTML", "CSS", "JavaScript", "PHP", "VB");
    printArray01($t);
}

function exp03() {
    $t = array();
    $t[0] = "Langage HTML";
    $t[1] = "Feuilles de styles";
    $t[2] = "POO en JavaScript";
    $t[3] = "Le langage PHP";
    printArray01($t);
}

function exp04() {
    $t[] = "Langage HTML 5";
    $t[] = "Feuilles de styles : CSS-3";
    $t[] = "POO en JavaScript - ES-5";
    $t[] = "Le langage PHP 5.7";
    printArray01($t);
}

function exp05() {
    $t[0] = "Langage HTML 5";
    $t[3] = "Feuilles de styles : CSS-3";
    $t[5] = "POO en JavaScript - ES-5";
    $t[8] = "Le langage PHP 5.7";
    printArray02($t);
}

function exp06() {
    $t["HTML"] = "Langage HTML 5";
    $t["CSS"] = "Feuilles de styles : CSS-3";
    $t["JS"] = "POO en JavaScript - ES-5";
    $t["PHP"] = "Le langage PHP 5.7";
    printArray02($t);
}

function exp07() {
    $t = array(
        "R01" => array("id" => "R01", "title" => "Langage HTML 5", "year" => 2019, "price" => 560.50),
        "R02" => array("id" => "R02", "title" => "Feuilles de styles : CSS-3", "year" => 2018, "price" => 670),
        "R03" => array("id" => "R03", "title" => "POO en JavaScript - ES-5", "year" => 2015, "price" => 750)
    );
    
    echo "<h2>" . $t["R02"]["title"] . "</h2>";
    printArray3($t);
}

