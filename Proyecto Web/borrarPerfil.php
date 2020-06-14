<?php
        $servidor = "fdb26.awardspace.net";
        $nombreusuario = "3443139_pruebas";
        $password = "abc123.@";
        $db = "3443139_pruebas";
        $conexion = mysqli_connect($servidor, $nombreusuario, $password, $db);

        if ($conexion->connect_error) {
            die("Conexión fallida: " . $conexion->connect_error);
        }
        if ((isset($_POST['nombre']) && !empty($_POST['nombre']))
        ) {
            $nombre = $_POST['nombre'];
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
        ?>