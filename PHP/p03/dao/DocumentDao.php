<?php
include_once '../models/Document.php';

interface DocumentDao {
    public function insert(Document $doc);
    public function select();
}

