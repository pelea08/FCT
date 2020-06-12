<?php

$servidor = "fdb26.awardspace.net";
$nombreusuario = "3443139_pruebas";
$password = "abc123.@";
$db = "3443139_pruebas";
$conexion = mysqli_connect($servidor, $nombreusuario, $password, $db);

if ($conexion->connect_error) {
    die("Conexión fallida: " . $conexion->connect_error);
} else {
    //Obtenemos el id publicacion
    $query = "SELECT Texto FROM comentarios where IdPublicacionRel= '" . $_GET["my_modal"] . "'";
    $result = mysqli_query($conexion, $query);
    if (!empty($result)) {
        $res = mysqli_fetch_array($result);



?>


        <!-- Mostrando la descripción de la base de datos-->

        <div class='modal-text'><?php echo $res[0] ?></div>

<?php

    } /*  <div class='modal-text'><?php echo $result[0]["comentarios"] ?></div> */
}
?>