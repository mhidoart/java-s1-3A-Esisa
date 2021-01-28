<?php
include_once '../models/User.php';

interface UserDao {
    public function insert(User $user);
    public function select($email);
}