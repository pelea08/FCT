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

        /* Esto es para que el tamaño de las casillas no ocupe todo lo ancho  */
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
            text-align: center;
            font-family: 'Pacifico', cursive;
        }
    </style>
    <title>iFream Registro</title>
</head>

<body>
    <div class="container">
        <form id="regiration_form" action="registro.php" method="POST">
            <fieldset>
                <h1><b>iFream</b></h1>
                <div id="centrador">
                    <img id="imagen" src="https://i.ibb.co/nmQN2BH/pruebas.png">
                </div>
                <div class="form-group">
                    <br>
                    <input type="text" class="form-control" name="usuario" id="usuario" placeholder="Usuario" maxlength="10">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="password" placeholder="Contraseña" maxlength="16">
                </div>
                <div class="form-group">
                    <select name="genero" id="genero" size="2">
                        <option selected>Hombre</option>
                        <option>Mujer</option>
                    </select>
                </div>
                <label for="start" id="start">Fecha Nacimiento:</label>
                <div class="form-group">
                    <input type="date" id="fecha" class="form-control" name="fecha" value="2018-07-22" min="1920-01-01" max="2002-12-31">
                </div>
                <input type="submit" class="submit btn btn-success" value="Registrarme" />
            </fieldset>
        </form>
        <div id="todoList">
            <?php
            $servidor = "fdb26.awardspace.net";
            $nombreusuario = "3443139_pruebas";
            $password = "abc123.@";
            $db = "3443139_pruebas";
            $conexion = mysqli_connect($servidor, $nombreusuario, $password, $db);

            if ($conexion->connect_error) {
                die("Conexión fallida: " . $conexion->connect_error);
            }
            if ((isset($_POST['usuario']) && !empty($_POST['usuario']))
                && (isset($_POST['password']) && !empty($_POST['password']))
                && (isset($_POST['fecha']) && !empty($_POST['fecha']))
            ) {

                $usuario = $_POST['usuario'];
                $password = $_POST['password'];
                $fecha = $_POST['fecha'];
                $genero = $_POST['genero'];
                $query1 = "SET FOREIGN_KEY_CHECKS = 0";
                mysqli_query($conexion, $query1);

                $query = "INSERT INTO usuario VALUES ('$usuario',ENCODE('$password', 'abc123'),'$fecha','$genero')";
                /* $query = "INSERT INTO usuario VALUES ('$usuario','$password','$fecha','$genero')"; */
                mysqli_query($conexion, $query);
            }
            ?>

        </div>
    </div>
</body>

</html>