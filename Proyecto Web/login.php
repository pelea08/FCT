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
        <form id="regiration_form" action="loguear.php" method="POST">
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
                <input type="submit" class="submit btn btn-success" value="Iniciar Sesión" />
            </fieldset>
        </form>
    </div>
</body>

</html>