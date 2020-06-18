<?php
$servidor = "fdb26.awardspace.net";
$nombreusuario = "3443139_pruebas";
$password = "abc123.@";
$db = "3443139_pruebas";
$conexion = mysqli_connect($servidor, $nombreusuario, $password, $db);
if ($conexion->connect_error) {
    die("Conexión fallida: " . $conexion->connect_error);
} else {
    $bla = $_GET["my_modal"];
    $a = $_GET["a"];
    $query = "SELECT Texto FROM comentarios where IdPublicacionRel= '$a'";

    $texto = mysqli_query($conexion, $query);

    if ($texto) {
        $query2 = "update comentarios SET Texto=CONCAT(Texto,'\n $bla') where IdPublicacionRel= '$a'";
        $updatee = mysqli_query($conexion, $query2);
    }
}
?>
