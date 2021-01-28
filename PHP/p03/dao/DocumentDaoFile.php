<?php

include_once 'DocumentDao.php';
include_once '../models/Document.php';

class DocumentDaoFile implements DocumentDao {
    private $source;
    
    public function __construct($source) {
        $this->source = $source;
    }
    
    public function select() {
        $docs = array();
        $f = fopen($this->source, "r");
        $row = fgets($f);
        while ($row) {
            $t = explode(",", $row);
            $doc = new Document($t[0], $t[1], $t[2]);
            $docs[] = $doc;
            $row = fgets($f);
        }
        fclose($f);
        return $docs;
    }

    public function insert(Document $doc) {
        $f = fopen($this->source, "a");
        fputs($f, $doc->getIsbn() . ", " . $doc->getTitle() . ", " . $doc->getYearPublished() . "\r\n");
        fclose($f);
    }
}

