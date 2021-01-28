<?php
include_once '../dao/DocumentDaoFile.php';
include_once '../business/BiblioService.php';

function open($source) {
    global $service;
    
    $dao = new DocumentDaoFile($source);
    $service = new BiblioService($dao);
    return $service;
}

open("C:/data/php/A/biblio.txt");
