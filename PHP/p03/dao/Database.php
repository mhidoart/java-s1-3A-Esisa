<?php
class Database {
    private $url;
    private $db;
    
    public function __construct($source, $userName="root", $password="") {
        $this->url = "mysql:host=localhost;dbname=$source;";
        $this->db = new PDO($this->url, $userName, $password);
    }
    
    public function insert($row, $tableName) {
        $values = implode("','", $row);
        $req = "INSERT INTO $tableName VALUES('" . $values . "')";
        return $this->db->exec($req);
    }
    
    public function select($tableName, $key = "", $value = "") {
        $req = "SELECT * FROM $tableName";
        if ($key) {
            $req = $req . " WHERE $key = '$value'";
        }
        $ps = $this->db->query($req); // PDOStatement
        $data = array();
        foreach ($ps as $row) {
            $data[] = $row;
        }
        return $data;
    }
}

