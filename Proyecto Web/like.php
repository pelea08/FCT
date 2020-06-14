<?php
$servidor = "fdb26.awardspace.net";
$nombreusuario = "3443139_pruebas";
$password = "abc123.@";
$db = "3443139_pruebas";
$conexion = mysqli_connect($servidor, $nombreusuario, $password, $db);

if ($conexion->connect_error) {
    die("Conexión fallida: " . $conexion->connect_error);
} else {
    $id = $_POST['id'];

    $query2 = "UPDATE `publicaciones` SET `Likes`=Likes+1 WHERE Identificador='$id'";
    mysqli_query($conexion, $query2);
    echo 'gg';
}
?>
