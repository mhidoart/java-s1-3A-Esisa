<?php
class Document {
    private $isbn;
    private $title;
    private $yearPublished;
    
    public function __construct($isbn, $title, $yearPublished) {
        $this->isbn = $isbn;
        $this->title = $title;
        $this->yearPublished = $yearPublished;
    }

    public function getIsbn() {
        return $this->isbn;
    }

    public function getTitle() {
        return $this->title;
    }

    public function getYearPublished() {
        return $this->yearPublished;
    }

    public function setIsbn($isbn) {
        $this->isbn = $isbn;
    }

    public function setTitle($title) {
        $this->title = $title;
    }

    public function setYearPublished($yearPublished) {
        $this->yearPublished = $yearPublished;
    }
}

