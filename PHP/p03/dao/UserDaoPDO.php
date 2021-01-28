<?php
include_once 'UserDao.php';
include_once 'Database.php';

class UserDaoPDO implements UserDao {
    private $db;
    
    public function __construct(Database $db) {
        $this->db = $db;    
    }
    
    public function select($email) {
        $data = $this->db->select("User", "email", $email);
        if (count($data) > 0) {
            $user = new User($data[0][0], $data[0][1], $data[0][2], $data[0][3]);
            return $user;
        }
        return null;
    }

    public function insert(User $user) {
        
    }
}