<?php
session_start();
$usuario = $_SESSION['username'];
if (!isset($usuario)) {
    header("location: login.php");
} else {
    /* echo "<head><meta http-equiv='refresh' content='2; url=añadirPublicacion.php'></head>"; */
    /*     echo " <script> 
<!--
window.location.replace('http://www.ejemplo.es'); 
//-->
</script>"; */
    /* exit; */
    /* echo'
    <html>
    <head>
    <title>Redirigir al navegador a otra URL</title>
    <META HTTP-EQUIV="REFRESH" CONTENT="5;URL=http://fctulises.atwebpages.com/web/añadirPublicacion.php">
    </head>
    <body>'; */
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
</head>

<body>

    <div class="container">

        <form class="well form-horizontal" action="" method="post" id="contact_form" enctype="multipart/form-data">
            <fieldset>
                <legend>
                    <center>
                        <h2><b>Formulario Publicación</b></h2>
                    </center>
                </legend><br>
                <button id=pep onclick="location.href='http://fctulises.atwebpages.com/web/inicioUsuario.php'" type="button">ATRAS</button>
                <div class="form-group">
                    <label class="col-md-4 control-label">Titulo</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-font"></i></span>
                            <input name="titulo" placeholder="Introduzca un titulo" class="form-control" type="text">
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-md-4 control-label">Categoria</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                            <select name="categoria" class="form-control selectpicker">
                                <option value="">Selecione Categoria</option>
                                <option>Automoviles</option>
                                <option>Moda</option>
                                <option>Tecnologia</option>
                                <option>Bricolage</option>
                                <option>Fotografia</option>
                                <option>Comida</option>
                                <option>Deporte</option>
                            </select>
                        </div>
                    </div>
                </div>
                <label class="col-md-4 control-label">Foto</label>
                <div class="input-group" id="f">
                    <div class="custom-file">
                        <input type="file" name="image" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
                        <label class="custom-file-label" for="inputGroupFile01"></label>
                    </div>
                </div>
                <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Success!.</div>
                <div class="form-group">
                    <label class="col-md-4 control-label"></label>
                    <div class="col-md-4"><br>
                        <!-- Esto lo puse asi para que me quedara bien el diseño -->
                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button type="submit" class="btn btn-warning">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspPublicar <span class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                </div>

            </fieldset>
        </form>
    </div>
    </div>
    <script>
        <?php
        $servidor = "fdb26.awardspace.net";
        $nombreusuario = "3443139_pruebas";
        $password = "abc123.@";
        $db = "3443139_pruebas";
        $conexion = mysqli_connect($servidor, $nombreusuario, $password, $db);

        if ($conexion->connect_error) {
            die("Conexión fallida: " . $conexion->connect_error);
        }
        if ((isset($_POST['titulo']) && !empty($_POST['titulo']))
            && (isset($_POST['categoria']) && !empty($_POST['categoria']))
        ) {
            session_start();
            $usuario = $_SESSION['username'];

            $file_tmp = $_FILES['image']['tmp_name'];


            $img = $_SERVER['DOCUMENT_ROOT'] . '/fotos/' . $_FILES["image"]["name"];

            move_uploaded_file($file_tmp, $img);
            $img1 = 'http://fctulises.atwebpages.com/fotos/' . $_FILES["image"]["name"];


            $titulo = $_POST['titulo'];
            $categoria = $_POST['categoria'];
            $query1 = "SET FOREIGN_KEY_CHECKS = 0";
            mysqli_query($conexion, $query1);

            $query = "INSERT INTO publicaciones (`Titulo`, `Imagen`, `Categoria`,`NombreR`) VALUES ('$titulo','$img1','$categoria','$usuario')";
            mysqli_query($conexion, $query);
            //por cada imagen que se inserte
            $query3 = "SELECT Identificador FROM publicaciones where Titulo='$titulo'";
            $verificar = mysqli_query($conexion, $query3);
            if ($verificar) {
                $identificador = mysqli_fetch_array($verificar);
                /* SET FOREIGN_KEY_CHECKS=0; */
                //Insertar comentario vacio
                $query4 = "INSERT into comentarios (Texto,IdPublicacionRel) VALUES ('','$identificador[0]')";
                mysqli_query($conexion, $query4);
            }
        }
        ?>
    </script>

</body>

</html>