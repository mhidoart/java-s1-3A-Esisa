<?php
    
session_start();
session_unset(); // supprimer toutes les variables de session
session_destroy(); // destruction de la session

include '../views/Logout.php';
