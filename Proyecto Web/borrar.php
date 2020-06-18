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
    </style>
    <title>iFream Registro</title>
</head>

<body>
    <table>
        <TR>
            <div class="col-sm-4">
                <div class="imagebox">
                    <a href=https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5e6fa1fd5bafe844fb2c00cd/dinosaurios-famosos_1.jpg id="pop">
                        <img width="100" height="100" src=https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5e6fa1fd5bafe844fb2c00cd/dinosaurios-famosos_1.jpg class="category-banner img-responsive">
                        <span class="imagebox-desc"> EPA </span>
                    </a>
                </div>
                <button type="button" id="comentarios" class="btn btn-default navbar-btn">Comentarios</button>
                <button type="button" id="seguir" class="btn btn-default navbar-btn">Seguir</button>
            </div>
            <div class="col-sm-4">
                <div class="imagebox">
                    <a href=https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5e6fa1fd5bafe844fb2c00cd/dinosaurios-famosos_1.jpg id="pop">
                        <img width="100" height="100" src=https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5e6fa1fd5bafe844fb2c00cd/dinosaurios-famosos_1.jpg class="category-banner img-responsive">
                        <span class="imagebox-desc"> EPA </span>
                    </a>
                </div>
                <button type="button" id="comentarios" class="btn btn-default navbar-btn">Comentarios</button>
                <button type="button" id="seguir" class="btn btn-default navbar-btn">Seguir</button>
            </div>
            <div class="col-sm-4">
                <div class="imagebox">
                    <a href=https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5e6fa1fd5bafe844fb2c00cd/dinosaurios-famosos_1.jpg id="pop">
                        <img width="100" height="100" src=https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5e6fa1fd5bafe844fb2c00cd/dinosaurios-famosos_1.jpg class="category-banner img-responsive">
                        <span class="imagebox-desc"> EPA </span>
                    </a>
                </div>
                <button type="button" id="comentarios" class="btn btn-default navbar-btn">Comentarios</button>
                <button type="button" id="seguir" class="btn btn-default navbar-btn">Seguir</button>
            </div>
            <div class="col-sm-4">
                <div class="imagebox">
                    <a href=https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5e6fa1fd5bafe844fb2c00cd/dinosaurios-famosos_1.jpg id="pop">
                        <img width="100" height="100" src=https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/5e6fa1fd5bafe844fb2c00cd/dinosaurios-famosos_1.jpg class="category-banner img-responsive">
                        <span class="imagebox-desc"> EPA </span>
                    </a>
                </div>
                <button type="button" id="comentarios" class="btn btn-default navbar-btn">Comentarios</button>
                <button type="button" id="seguir" class="btn btn-default navbar-btn">Seguir</button>
            </div>
        </TR>
    </table>
</body>

</html>