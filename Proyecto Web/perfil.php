<?php
session_start();
$usuario = $_SESSION['username'];
if (!isset($usuario)) {
    header("location: login.php");
} else {
    $servidor = "fdb26.awardspace.net";
    $nombreusuario = "3443139_pruebas";
    $password = "abc123.@";
    $db = "3443139_pruebas";
    $conexion = mysqli_connect($servidor, $nombreusuario, $password, $db);

    if ($conexion->connect_error) {
        die("Conexión fallida: " . $conexion->connect_error);
    } else {

        $query1 =  "SELECT COUNT(*) total FROM sigue WHERE nombreSeguido='$usuario'";

        $query2 =  "SELECT COUNT(*) total FROM publicaciones WHERE NombreR='$usuario'";

        $query3 =  "SELECT COUNT(*) total FROM sigue WHERE nombreSeguidor='$usuario'";

        $resultado1  = mysqli_query($conexion, $query1);
        $resultado2  = mysqli_query($conexion, $query2);
        $resultado3  = mysqli_query($conexion, $query3);
        $contadorSeguidores = mysqli_fetch_assoc($resultado1);
        $contadorPublicaciones = mysqli_fetch_assoc($resultado2);
        $contadorSeguidos = mysqli_fetch_assoc($resultado3);
    }
}
?>
<html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <style type="text/css">
        #success_message {
            display: none;
        }

        #f {
            text-align: left;

            /* ojo poner esto donde custom file */
        }
    </style>
    <title>iFream Registro</title>

<body>

    <div class="container">

        <form class="well form-horizontal" action="" method="post" id="contact_form">
            <fieldset>
                <legend>
                    <center>
                        <h2><b>Mi Perfil</b></h2>
                    </center>
                </legend><br>
                <button id=pep onclick="location.href='http://fctulises.atwebpages.com/web/inicioUsuario.php'" type="button">ATRAS</button>
                <div class="form-group">
                    <label class="col-md-4 control-label">Nombre Usuario</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <input name="titulo" value="<?php echo $usuario; ?>" class="form-control" type="text" readonly="readonly">
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-md-4 control-label">Publicaciónes</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group">
                            <input name="titulo" value="<?php echo $contadorPublicaciones['total']; ?>" class="form-control" type="text" readonly="readonly">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">Seguidores</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group">
                            <input name="titulo" value="<?php echo $contadorSeguidores['total']; ?>" class="form-control" type="text" readonly="readonly">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">Seguidos</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group">
                            <input name="titulo" value="<?php echo $contadorSeguidos['total']; ?>" class="form-control" type="text" readonly="readonly">
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-md-4 control-label"></label>
                    <div class="col-md-4"><br>

                        <!-- Esto lo puse asi para que me quedara bien el diseño -->
                        <!-- &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button type="button" onclick="borrar()" class="btn btn-warning">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspEliminar Cuenta Y Cerrar Sesión <span class="glyphicon glyphicon-trash"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</button> -->
                        <input type="submit" name="test" id="test" class="btn btn-warning" value="Eliminar Cuenta Y Cerrar Sesión"></input>
                    </div>
                </div>

            </fieldset>
        </form>
    </div>
    <?php
    function a()
    {
        $servidor = "fdb26.awardspace.net";
        $nombreusuario = "3443139_pruebas";
        $password = "abc123.@";
        $db = "3443139_pruebas";
        $conexion = mysqli_connect($servidor, $nombreusuario, $password, $db);

        if ($conexion->connect_error) {
            die("Conexión fallida: " . $conexion->connect_error);
        } else {
            session_start();
            $nombre = $_SESSION['username'];
            $query1 = "SET FOREIGN_KEY_CHECKS = 0";
            mysqli_query($conexion, $query1);

            $query = "DELETE FROM publicaciones where NombreR='$nombre'";
            mysqli_query($conexion, $query);

            $query2 = "DELETE FROM sigue where nombreSeguido='$nombre'";
            mysqli_query($conexion, $query2);

            $query3 = "DELETE FROM sigue where nombreSeguidor='$nombre'";
            mysqli_query($conexion, $query3);

            $query4 = "DELETE FROM usuario where nombre='$nombre'";
            mysqli_query($conexion, $query4);
        }
    }
    if (array_key_exists('test', $_POST)) {
        a();
        //Tarda 2 segundos y redirecionan al loguin y rompe la sesion
        echo '<meta http-equiv="Refresh" content="2;url=http://fctulises.atwebpages.com/web/logout.php">';
    }
    ?>
    <script>

    </script>

</body>
</head>

</html>