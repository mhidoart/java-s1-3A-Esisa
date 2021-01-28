<?php
include_once '../actions/BusinessFactoryPDO.php';
include_once '../models/Document.php';

$doc = new Document($_POST["isbn"], $_POST["title"], $_POST["yearPublished"]);
$service->addDocument($doc);

include '../views/NouveauDocumentOk.php';

