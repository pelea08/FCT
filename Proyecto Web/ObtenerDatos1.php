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
                $bla= $_GET["my_modal"];
                $a=$_GET["a"];
                $query = "SELECT Texto FROM comentarios where IdPublicacionRel= '$a'";

                $texto = mysqli_query($conexion, $query);

                if ($texto) {
                    //hacer update

                    $query2 = "update comentarios SET Texto=CONCAT(Texto,'\n $bla') where IdPublicacionRel= '$a'";
                    $updatee = mysqli_query($conexion, $query2);
                } else {

                    $omitir = "SET FOREIGN_KEY_CHECKS=0";
                    mysqli_query($conexion, $omitir);
        
                    $query3 =  "INSERT INTO comentarios( Texto, IdPublicacionRel) VALUES ('$bla', '$a')";

                    $insertt = mysqli_query($conexion, $query3);
                }
            }
?>