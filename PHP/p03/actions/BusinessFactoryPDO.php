<?php
include_once '../dao/DocumentDaoPDO.php';
include_once '../dao/UserDaoPDO.php';
include_once '../business/BiblioService.php';

function open($source) {
    global $service;
    
    $db = new Database($source);
    $dao = new DocumentDaoPDO($db);
    $userDao = new UserDaoPDO($db);
    $service = new BiblioService($dao, $userDao);
    
    return $service;
}

//open("Documents");
open("Biblio");

function login() {
    global $service;
    
    session_start();
    if (isset($_SESSION["login"]) && isset($_SESSION["password"])) {
        $user = $service->login($_SESSION["login"], $_SESSION["password"]);
        return $user;
    }
    return null;
}