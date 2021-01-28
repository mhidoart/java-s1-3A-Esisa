<?php
include_once '../models/Document.php';
include_once '../dao/DocumentDao.php';
include_once '../dao/UserDao.php';

class BiblioService {
    private $dao;
    private $userDao;
    
    public function __construct(DocumentDao $dao, UserDao $userDao) {
        $this->dao = $dao;
        $this->userDao = $userDao;
    }
    
    public function documents() {
        return $this->dao->select();
    }
    
    public function addDocument(Document $doc) {
        $this->dao->insert($doc);
    }
    
    public function login($email, $password) {
        $user = $this->userDao->select($email);
        if ($user) {
            if ($user->getPassword() == $password) {
                return $user;
            }
        }
        return null;
    }
}