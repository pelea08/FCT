<?php
$servidor = "fdb26.awardspace.net";
$nombreusuario = "3443139_pruebas";
$password = "abc123.@";
$db = "3443139_pruebas";
$conexion = mysqli_connect($servidor, $nombreusuario, $password, $db);

if ($conexion->connect_error) {
    die("Conexión fallida: " . $conexion->connect_error);
} else {
    //hacer un select y comprobar si l campo texto es vacio si lo es entoces hacer insert y si no hacer update con el concat
    /*  SELECT Texto from comentarios where IdPublicacionRel=1  */
    $id = $_POST['id'];
    $texto = $_POST['texto'];

    $query2 = "update comentarios SET Texto=CONCAT(Texto,'\n $texto') where IdPublicacionRel= '$id'";
    mysqli_query($conexion, $query2);
}
?>