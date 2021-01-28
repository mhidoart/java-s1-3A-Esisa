<?php
include_once '../actions/BusinessFactoryPDO.php';

$user = $service->login($_POST["login"], $_POST["password"]);

session_start();
$_SESSION["login"] = $_POST["login"];
$_SESSION["password"] = $_POST["password"];

if ($user) {
    include '../views/LoginOk.php';
}
else {
    $message = "Nom d'utilisateur ou Mot de passe incorrect";
    include '../views/Error.php';
}
