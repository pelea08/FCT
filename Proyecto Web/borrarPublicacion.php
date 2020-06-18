<?php
session_start();
$usuario = $_SESSION['username'];
if (!isset($usuario)) {
    header("location: login.php");
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <style type="text/css">
        #regiration_form fieldset:not(:first-of-type) {
            display: none;
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

        #logout {
            text-align: center;
        }

        #displayData {
            display: block;
            text-align: center;
        }

        #barraGrande {
            margin: inherit;
        }
    </style>
    <script language="javascript" type="text/javascript">

    </script>
    <title>iFream Registro</title>
</head>

<body>

    <div class="centrador">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-brand" id="logout">
                <label>Introduzca ID</label><br>
                <input type="text" id="fname" name="fname"><br>
                <button onclick="openOnImageClick()" type="button"> Borrar</button><br>
            </div>
            <div id=barraGrande class="navbar-collapse collapse">
                <button type="button" onclick="location.href='http://fctulises.atwebpages.com/web/inicioUsuario.php'" id=pep class="btn btn-default navbar-btn">Atras</button>
                <ul class="nav navbar-nav navbar-right">
                    <li><button onclick="location.href='logout.php'" type="button"> <input type="image" src="http://fctulises.atwebpages.com/web/logout.png"></button></li>
                </ul>
            </div>
        </nav>
    </div>
    <br>
    <div class="row">
        <div class="container" id="displayData">
        </div>

        <script>
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function() {
                if (this.readyState == 4 & this.status == 200) {
                    var dataArray = JSON.parse(this.responseText);
                    var i;
                    var a = 0;
                    var displayData = "";
                    for (i in dataArray) {
                        displayData += ' <div class="col-sm-4">' +
                            ' <div class="imagebox">' +
                            '<img src=' + dataArray[i].Imagen + ' class="category-banner img-responsive" id="foto"  >' +
                            '<span class="imagebox-desc">' + "" + dataArray[i].Titulo + "<br> ID:" + dataArray[i].Identificador + '</span>' +
                            '</a>' +
                            '</div>' +
                            '</div> ';
                    }
                }
                document.getElementById("displayData").innerHTML = displayData;
            };

            xmlhttp.open("GET", 'http://fctulises.atwebpages.com/src/post.php?NombreR=' + "<?php echo $usuario; ?>", true);
            xmlhttp.send();

            function openOnImageClick() {
                var almacenIdentificadores = [10];
                var input = document.getElementById("fname");
                var numero = input.value;
                alert(numero)
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function() {
                    if (this.readyState == 4 & this.status == 200) {
                        var dataArray = JSON.parse(this.responseText);
                        var i;
                        var displayData = "";
                        for (i in dataArray) {
                            if (dataArray[i].NombreR == "<?php echo $usuario; ?>") {
                                almacenIdentificadores += dataArray[i].Identificador;
                            }
                        }
                    }
                };
                xmlhttp.open("DELETE", 'http://fctulises.atwebpages.com/src/post.php?NombreR=' + "<?php echo $usuario; ?>" + '&Identificador=' + numero, true);
                xmlhttp.send();
                location.reload();
            }
        </script>
</body>

</html>