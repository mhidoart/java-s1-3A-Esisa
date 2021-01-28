<?php
include_once '../actions/BusinessFactoryPDO.php';
include_once '../models/Document.php';

if (login()) {
    $docs = $service->documents();
    
    include '../views/ListeDesDocuments.php';
}
else {
    $message = "Utilisateur non authentifié!";
    include '../views/Error.php';
}