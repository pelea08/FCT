
<?php
$servidor = "fdb26.awardspace.net";
$nombreusuario = "3443139_pruebas";
$password = "abc123.@";
$db = "3443139_pruebas";
$conexion = mysqli_connect($servidor, $nombreusuario, $password, $db);

if ($conexion->connect_error) {
    die("Conexión fallida: " . $conexion->connect_error);
}
if ((isset($_POST['usuario1']) && !empty($_POST['usuario1']))
    && (isset($_POST['usuario2']) && !empty($_POST['usuario2']))
) {
    $usuario1 = $_POST['usuario1']; //AutoPubli
    $usuario2 = $_POST['usuario2']; //UsuActual

    $query12 = "SET FOREIGN_KEY_CHECKS = 0";
    mysqli_query($conexion, $query12);

    $query1 =  "SELECT * FROM `sigue` WHERE nombreSeguido='$usuario1' and nombreSeguidor='$usuario2'";
    $query = mysqli_query($conexion, $query1);

    if (mysqli_num_rows($query) == 0) {
        //Creamos la relacion

        $query2 = "INSERT INTO `sigue`(`nombreSeguido`, `nombreSeguidor`) VALUES ('$usuario1','$usuario2')";
        mysqli_query($conexion, $query2);
        echo 'asdasdasdasdas';
    } else {
        echo 'merda';
    }
}
?>
