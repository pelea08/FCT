<?php
require 'conexion.php';
session_start();

$usuario = $_POST['usuario'];
$password = $_POST['password'];

/* $query1 =  "SELECT * FROM usuario WHERE nombre='$usuario' AND contrasena=aes_decrypt('$password', 'abc123')   "; */
$query1 =  "select nombre,contrasena FROM usuario WHERE nombre='$usuario' and DECODE(contrasena, 'abc123')='$password'";

$query = mysqli_query($conexion, $query1);

if (!$query ) {
    echo ("Error description: " . mysqli_error($conexion) . "query : " . $query1);
} else if (mysqli_num_rows($query) == 1) {
    $_SESSION['username'] = $usuario;
    header("location: inicioUsuario.php");
} else {
    echo "Usuario Invalido";
    //ojo para qeu redirecione a login .php
    /* header("location: login.php"); */
}
?>