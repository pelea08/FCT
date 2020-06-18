<?php
session_start();
session_destroy();
header("location: login.php"); // Redireccionando a la pagina index.php
exit();
