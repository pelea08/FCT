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
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <!-- <script src="https://code.jquery.com/jquery-2.0.3.js"></script> -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <style type="text/css">
        #regiration_form fieldset:not(:first-of-type) {
            display: none;
        }

        #categoria {
            text-align: center;
        }

        .form-group {
            width: 300px;
        }

        #fecha {
            text-align: center;
        }

        .container {
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        #centrador {
            text-align: center;
            width: 300px;
            height: 150px;
        }

        #imagen {
            width: 150px;
        }

        h1 {
            color: #2196f3;
            text-align: left;
            font-family: 'Pacifico', cursive;
            margin: 20px;
            position: absolute;
        }

        .imagebox {
            background: black;
            padding: 0px;
            position: relative;
            text-align: center;
            width: 100%;
        }

        .imagebox img {
            opacity: 1;
            transition: 0.5s opacity;
        }

        .imagebox .imagebox-desc {
            background-color: rgba(0, 0, 0, 0.6);
            bottom: 0px;
            color: white;
            font-size: 1.2em;
            left: 0px;
            padding: 10px 15px;
            position: absolute;
            transition: 0.5s padding;
            text-align: center;
            width: 100%;
        }

        .imagebox:hover img {
            opacity: 0.7;
        }

        .imagebox:hover .imagebox-desc {
            padding-bottom: 10%;
        }

        .navbar-brand {
            position: absolute;
            width: 100%;
            left: 0;
            text-align: center;
            margin: 0 auto;
        }

        .navbar-toggle {
            z-index: 3;
        }

        .gallery {
            -webkit-column-count: 3;
            -moz-column-count: 3;
            column-count: 3;
            -webkit-column-width: 33%;
            -moz-column-width: 33%;
            column-width: 33%;
        }

        .gallery .pics {
            -webkit-transition: all 350ms ease;
            transition: all 350ms ease;
        }

        .gallery .animation {
            -webkit-transform: scale(1);
            -ms-transform: scale(1);
            transform: scale(1);
        }

        @media (max-width: 450px) {
            .gallery {
                -webkit-column-count: 1;
                -moz-column-count: 1;
                column-count: 1;
                -webkit-column-width: 100%;
                -moz-column-width: 100%;
                column-width: 100%;
            }
        }

        @media (max-width: 400px) {
            .btn.filter {
                padding-left: 1.1rem;
                padding-right: 1.1rem;
            }
        }

        #pep {
            padding: 24px;
            background-color: #2196f3;
            color: white;
        }

        #pepe {
            padding: 24px;
            background-color: #2196f3;
            color: yellow;
        }

        #comentarios {
            background-color: #ACF881;
        }

        #seguir {
            background-color: #2196f3;
        }

        #displayData {
            display: block;
            text-align: center;
        }

        #fname {
            text-align: center;
        }
    </style>
    <title>iFream Registro</title>
</head>

<body>
    <div class="centrador">
        <nav class="navbar navbar-default" role="navigation">
            <!-- <h1>iFream</h1> -->
            <label class="navbar-brand" for="fname">Seguidores: <?php echo $contadorSeguidores['total']; ?> Publicaciónes: <?php echo $contadorPublicaciones['total']; ?>Seguidos: <?php echo $contadorSeguidos['total']; ?></label>
            <br>
            <label class="navbar-brand" for="fname">Nombre Usuario: <?php echo $usuario; ?> </label>
            <br>
            <a class="navbar-brand" href="http://fctulises.atwebpages.com/web/inicioUsuario.php"><input type="image" id="logout" alt="Login" src="http://fctulises.atwebpages.com/web/logo.png"></a>
            <div class="navbar-collapse collapse">
                <button type="button" onclick="location.href='http://fctulises.atwebpages.com/web/añadirPublicacion.php'" id=pep class="btn btn-default navbar-btn">Compartir Publicación</button>
                <button type="button" onclick="location.href='http://fctulises.atwebpages.com/web/borrarPublicacion.php'" id=pepe class="btn btn-default navbar-btn">Borrar Publicación</button>
                <button type="button" onclick="location.href='http://fctulises.atwebpages.com/web/inicioUsuario.php'" id=pepe class="btn btn-default navbar-btn">Recargar Web</button>
                <ul class="nav navbar-nav navbar-right">
                    <li><button onclick="location.href='logout.php'" type="button"> <input type="image" id="logout" alt="Login" src="http://fctulises.atwebpages.com/web/logout.png"></button></li>
                </ul>

            </div>
        </nav>
    </div>
    <div class="row">
        <div class="col-md-12 d-flex justify-content-center mb-5" id="categoria">

            <button type="button" class="btn btn-outline-black waves-effect filter" onclick="location.reload()">Todo</button>
            <button type="button" class="btn btn-outline-black waves-effect filter" value="Automoviles" id="Automoviles" onclick="myFunction()">Automóviles</button>
            <button type="button" class="btn btn-outline-black waves-effect filter" value="Tecnologia" id="Tecnologia" onclick="myFunction()">Tecnología</button>
            <button type="button" class="btn btn-outline-black waves-effect filter" value="Moda" id="Moda" onclick="myFunction()">Moda</button>
            <button type="button" class="btn btn-outline-black waves-effect filter" value="Comida" id="Comida" onclick="myFunction()">Comida</button>
            <button type="button" class="btn btn-outline-black waves-effect filter" value="Deporte" id="Deporte" onclick="myFunction()">Deportes</button>

        </div>
        <br><br><br><br><br>

        <div class="container" id="displayData">
        </div>
        <div class="modal fade" id="bootstrap-modal" role="dialog">
            <div class="modal-dialog" role="document">
                <!-- Modal contenido-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Comentarios</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                    </div>
                    <div class="modal-body">
                        <div id="conte-modal"></div>
                    </div>
                    <div class="modal-footer">
                        <div id="conte-modal1"></div>
                        <div id="fname">
                            <input type="text" id="faname" name="fname" value=""><br><br>
                            <button type="button" id="btnSave" onclick="com()">Añadir comentario</button>

                        </div>
                        <br>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <script>
        function com() {
            var bla = $('#faname').val();
            var a=document.getElementById("comentarios").value;
            console.log(a+"");
            //Enviar variable usuario concatenada
            $('#conte-modal1').load('ObtenerDatos1.php?my_modal=' + bla+'&a='+a, function() {

            });
        }
    </script>
    <script>
        function seguir() {

            var botones1 = document.getElementsByClassName('btn btn-default navbar-btn');

            for (var i = 0; i < botones1.length; i++) {
                botones1[i].addEventListener("click", capturar1);
            }


            function capturar1() {
                console.log(this.value);

                /* var resIDD = this.id.toString(); */
                /* $res1 = this.id.toString(); */
                var resIDD = this.value;
                //Es una manera de pasar la variable
                window.location.href = window.location.href + "?resIDD=" + resIDD;
                <?php

                $servidor = "fdb26.awardspace.net";
                $nombreusuario = "3443139_pruebas";
                $password = "abc123.@";
                $db = "3443139_pruebas";
                $conexion = mysqli_connect($servidor, $nombreusuario, $password, $db);

                if ($conexion->connect_error) {
                    die("Conexión fallida: " . $conexion->connect_error);
                } else {
                    $var_PHP = $_GET["resIDD"];
                    $query1 =  "SELECT NombreR FROM publicaciones where Identificador='$var_PHP'";

                    $autorPublicacion1 = mysqli_query($conexion, $query1);

                    if ($autorPublicacion1) {
                        $autorPublicacion2 = mysqli_fetch_array($autorPublicacion1);

                        //Para que no se pueda seguir a si mismo
                        if ($autorPublicacion2[0] != $usuario) {
                            $query3 = "INSERT INTO `sigue`(`nombreSeguido`, `nombreSeguidor`) VALUES ('$autorPublicacion2[0]','$usuario')";
                            mysqli_query($conexion, $query3);
                            /* header("Location: inicioUsuario.php"); */
                        }
                    }
                }
                ?>
            }
        }
    </script>
    <script>
        function ventanaModal(modal) {
            var options = {
                modal: true,
                height: 300,
                width: 600
            };
            //JQUERY
            $('#conte-modal').load('ObtenerDatos.php?my_modal=' + modal, function() {
                $('#bootstrap-modal').modal({
                    show: true
                });
            });
        }
    </script>


    <script>
        function myFunction() {

            var botones = document.getElementsByClassName('btn btn-outline-black waves-effect filter');

            for (var i = 0; i < botones.length; i++) {
                botones[i].addEventListener('click', capturar);
            }

            function capturar() {
                console.log(this.id);
                var res = this.id.toString();
                var objeto = new Object();
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function() {
                    if (this.readyState == 4 & this.status == 200) {
                        var dataArray = JSON.parse(this.responseText);
                        var i;
                        var displayData = "";
                        var bandera = false;
                        for (i in dataArray) {
                            if (dataArray[i].Categoria == res) {
                                displayData += ' <div class="col-sm-4">' +
                                    ' <div class="imagebox">' +
                                    '<a href=' + dataArray[i].Imagen + ' id="pop">' +
                                    '<img src=' + dataArray[i].Imagen + ' class="category-banner img-responsive">' +
                                    '<span class="f">' + dataArray[i].Titulo + '</span>' +
                                    '</a>' +
                                    '</div>' +
                                    '<button type="button" id="comentarios" class="btn btn-default navbar-btn" value=' + dataArray[i].Identificador + ' data-toggle="modal" data-target="#miModal" onclick="ventanaModal(' + dataArray[i].Identificador + ')">Comentarios</button>' +
                                    ' <button type="button" id="seguir" class="btn btn-default navbar-btn" value=' + dataArray[i].Identificador + '  onclick="seguir()" >Seguir</button>' +
                                    '</div> ';

                            }
                        }
                    }
                    document.getElementById("displayData").innerHTML = displayData;
                };
                xmlhttp.open("GET", "http://fctulises.atwebpages.com/src/post.php", true);
                xmlhttp.send();

            }
        }
    </script>
    <script>
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 & this.status == 200) {
                var dataArray = JSON.parse(this.responseText);
                var i;
                var displayData = "";
                for (i in dataArray) {
                    displayData += ' <div class="col-sm-4">' +
                        ' <div class="imagebox">' +
                        '<a href=' + dataArray[i].Imagen + ' id="pop">' +
                        '<img src=' + dataArray[i].Imagen + ' class="category-banner img-responsive">' +
                        '<span class="imagebox-desc">' + dataArray[i].Titulo + '</span>' +
                        '</a>' +
                        '</div>' +
                        '<button type="button" id="comentarios" class="btn btn-default navbar-btn" value=' + dataArray[i].Identificador + ' data-toggle="modal" data-target="#miModal" onclick="ventanaModal(' + dataArray[i].Identificador + ')">Comentarios</button>' +
                        ' <button type="button" id="seguir" class="btn btn-default navbar-btn" value=' + dataArray[i].Identificador + ' onclick="seguir()" >Seguir</button>' +
                        '</div> ';
                }
            }
            document.getElementById("displayData").innerHTML = displayData;
        };
        xmlhttp.open("GET", "http://fctulises.atwebpages.com/src/post.php", true);
        xmlhttp.send();
    </script>


</body>

</html>