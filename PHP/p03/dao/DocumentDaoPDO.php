<?php
include_once 'DocumentDao.php';
include_once 'Database.php';

class DocumentDaoPDO implements DocumentDao {
    private $db;
    
    public function __construct(Database $db) {
        $this->db = $db;
    }
    
    public function select() {
        $docs = array();
        $data = $this->db->select("Titles");
        foreach ($data as $row) {
            $doc = new Document($row[0], $row[1], $row[2]);
            $docs[] = $doc;
        }
        return $docs;
    }

    public function insert(Document $doc) {
        $this->db->insert(array($doc->getIsbn(), $doc->getTitle(), $doc->getYearPublished()), "Document");
    }
}

