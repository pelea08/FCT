# FCT
15/05/2020- Descripción de la aplicación, diseño de pantallas para el móvil, versión mínima, entornos desarrollo y algunos apartados más.
Diseño logotipo y hacer fondo transparente y elección de colores de la app para que combine.
Repaso modelo Entidad-Relación.

16/05/2020- Diseñando formulario registrarse para app web e inserción datos base de datos, alinearlo, darle estilos...
Introducción segundo idioma en la app móvil.
Problemas a la hora de añadir información a la base de datos me da un error y estoy investigando pero de momento no fui capaz mañana seguiré intentándolo.

17/05/2020- Conseguí insertar datos en base de datos desde la app web. Diseñar página login. Cambiar tipografía todo app web y app móvil.
Búsqueda de servicio en red gratuito para MySQL y hacer los registros de los usuarios online.
Implementar la inserción de datos en la base de datos en la app móvil, pero me está dando problemas.
Registro dominio gratuito ftp para la subida del código php para implementar en Android me está dando muchos problemas porque estoy intentando conseguir una url publica para implementarlo.
Hasta dentro de 48 horas no puedo hacer pruebas debido a que mi dominio se tiene que registrar en los dns para ser accesibles.
Añadir genero app móvil y web e implementarlo en la base de datos online. App móvil sigue dando problemas para insertar.

18/05/2020- Nuevo errores a la hora de insertar información en la base de datos desde el móvil,
posibles solución estoy intentando conseguir un certificado gratuito SSL pero me está dando muchos problemas estoy a la espera de que me lo aprueben.
Realización modelo Entidad-relación y del modelo Entidad-Relación
Diseñara pantalla de inicio para escoger si iniciar sesión o registrar en app web todo esto subido al hosting y que sea accesible desde internet.

19/05/2020- Migrar mi base de datos de un servidor a otro debido a que el primero que hice me da muchísimos fallos, invertí bastante tiempo en encontrar una gratuita y que funcionase
y al final me quede con esta www.freemysqlhosting.net.
Investigando otras formas de insertar datos mediante la app en android. Lo mirare en otro momento porque estoy perdiendo mucho tiempo.
Actualización modelo entidad relación y modelo relacional.
Hacer login app web contra la base de datos online,2 horas "perdidas" porque en la base de datos tenía contraseña y nunca me diera problema y
al hacer el select y al poner contraseña me daba problemas y resulta que fue ir a la base de datos y cambiar la n por la ñ(pasar de contraseña a contraseña) y listo.

20/05/2020- Adquirí otro hosting gratuito debido a que me está dando muchos problemas el que tengo para ejecutar el fragmento de código de php almacenado y me he informado y esta es la conclusión.
Después de mucho tiempo haciendo pruebas voy a probar a hacer otro método diferente de inserción de datos porque este me da muchísimos problemas.
Conseguí solucionar tanto el login como el registrarse de la app móvil y web la solución final fue cambiar absolutamente todo de hosting y desde este nuevo hosting me dejo hacer todo sin errores.
Problemas a la hora de insertar fecha desde la app móvil, conseguí solucionarlo.

21/05/2020- Diseño y planificación de la pantalla que va a ver el usuario una vez logeado de manera exitosa en la app móvil.
Volví a corregir el tema de las claves foráneas que las tenías mal referenciadas.
Me estoy encontrando con problemas a la hora pasar de la pantalla login a visualizar las publicaciones. 
Conseguí solucionarlo ahora las fotos a mostrar y valores toca extraelos de la base de datos para mostrarlo en el móvil.

22/05/2020- Modifique la base de datos otra vez porque tenía los nombres incorrectos.
Entre las 11,30 y las 14,00 horas tuve que llevar a mi madre a urgencias debido a que tuvo un accidente laboral, pongo esto por si se ve una diferencia de cantidad de 
trabajo respecto a los otros días aun así el resto del día hasta la noche seguiré trabajando como siempre.
Al insertar usuarios nuevos debido a que puse el tema de las claves foráneas de manera adecuada ahora me está dando problemas.
Conseguí solucionarlo.
Mediante JDBC ahora voy a extraer los datos de mi base de datos como, por ejemplo, después de probar muchas cosas me doy de cuenta que está obsoleto  da problemas y me pongo rumbo a aprender 
implementar Rest API.

23/05/2020-Adaptanción para que en versiones superiores a android 7 no me sea problemas al pedir el archivo de la sentencia insert o select.
Cambiar los textview del año, mes y día por un calendario, tengo que usar el datepicker, pero me está dando problemas y tengo que cambiar bastantes cosas.
Al final lo solucione hice un datepicker mediante show dialog al pulsar un boton muestra el calendario porque me daba muchos problemas.
Por fin conseguí solucionar el problema que ayer a la noche me estuvo ayudando Javi que en su momento le hice un apaño.
Implementando restFul y me funciono soy capaz mediante la app del móvil hacer consulta y que me devuelva por ejemplo el título de las publicaciones.

24/05/2020-Adaptando todo lo de restful(app móvil) a para que aparezca toda la información colocada de la manera adecuada, después de invertir mucho tiempo me está dando problemas coger la ruta de la 
imagen y visualizarla lo voy a dejar para otro momento y mientras tanto voy a pensar y hacer el diseño de la app web una vez logeado el usuario.
Investigando como consumir Rest con Json en HTML, estoy probando métodos distintos y me está costando muchísimo ponerlo a funcionar.
He conseguido visualizar por ejemplo los nombres de las publicaciones(online) en el HTML ahora tengo que conseguir hacer publicaciones con los datos obtenidos.

25/05/2020-Diseñando el bucle para que me genere un light box con las fotos y títulos de la base de datos mediante JavaScript.
Mejorando el diseño de la app web, añadir página para añadir publicaciones que se añada a la base de datos online y diseñarla.
Problemas a la hora de añadir porque me está costando subir la foto al hosting de manera automática ala añadir la publicación.
Me inserta todo correctamente, pero la foto me da problemas.

26/05/2020-Sigo rompiendo la cabeza con como insertar la foto, me costó mucho, pero lo conseguí el gran problema es que mi hosting tenía una protección del tema de los permisos
y pese que los permisos estaban bien al tener la protección impedía la subida. 
Mejora formularia de publicación.

27/05/2020-Volvemos a la app móvil a intentar consumir json de manera adecuada la foto me da problemas al convertir a bitmap la url de a foto.
Lo único que conseguí fue que me muestre y título asociado pero la foto me dé un error de red y me está volviendo loco.
Descubrí que la manera que lo tengo que hacer es mediante AsynkTask la cuestión es que lo adapte y las fotos no me las convierte bien hice una dura tarea de depuración a fondo
pero no lo conseguí solucionar y tengo dudas si en realidad el problema es de mi hosting y no de mi código. Mañana investigare un poco más al respecto.

28/05/2020-Sigo con lo de ayer que creo que estoy a punto de conseguirlo. Si meto en un enlace de una foto cualquiera de internet me funciona y hace lo que tiene que hacer.
Después de probar mil cosas más y saber que el error es de tipo 403 de redirección y aun así leer mucho en internet me sigue haciendo el mismo comportamiento y he pedido ayuda a javi.
Javi me ayudo y simplemente tenía todo correcto y fue añadir una línea de código que dice que antes de cargar todo pasa por mi aplicación web y así las fotos las carga porque esto es una
medida de protección que hace el hosting para tener menos tráfico.
Hacer botones flotantes en la pantalla de cuando te logues y ves todas las publicaciones un botón flotante te cierra sesión y te lleva a la ventana en donde eliges si iniciar sesión
o registrarte y el otro botón flotante te lleva a una pantalla donde añades una publicación. Diseñar pantalla de añadir publicación.
Problemas a la hora de insertar datos en la base de datos.


29/05/2020- Abrir todos los archivos php y organizar el código y borrar el que sobra. Añadir cosas anteproyecto. 
Conseguí añadir título y categoría desde app móvil  ahora investigar el tema de subir foto desde el móvil.
Llevo toda la tarde probando diferentes formas y códigos para insertar x foto de la galería de mi móvil a la base de datos y nada también probé localhost.

30/05/2020- Sigo investigando como subir las, pero me da muchos problemas todos los métodos que probé y creo que lo voy a dejar para otro momento.
Establecer sesiones php para por ejemplo no puedas añadir una publicación o ver publicaciones sin loguearte con anterioridad, al ser con la base de datos online me dio algunos errores.
Modularice  código del php.

31/05/2020- Encriptar todas las contraseñas de la base de datos, al cambiar esto tuve que cambiar todos mis fragmentos de código php del login porque hay que 
descifrar y probé diferentes métodos de encriptación.
Realice la página de eliminar publicaciones, de momento lo que tengo echo es si yo me logeo y voy al apartado borrar publicaciones en la página solo aparecen 
mis publicaciones no todas en general todo esto en la app web.

01/06/2020- Modificación en donde añado publicaciones para detectar automáticamente el usuario que lo publica.
Me está dando muchos problemas que el usuario cuando pinchas en su foto se borre automáticamente lo estoy haciendo mediante jQuery pero me da mil problemas.
Después de dedicar casi toda la tarde cambie la forma y fui capaz de realizar el objetivo.
Mejoras generales de diseño en la página de borrar publicaciones.

02/06/2020-Volvi a lo de añadir publicación desde el movil que tantos problemas y nada despues de dedicarle bastante horas estoy en la misma pero de difrente manera y he cedido
pedirle ayuda a javi.
Realización de contador de seguidores de cada usuario en la pantalla de inicio todo esto vinculado a la base de datos online.
Tambien añadi un contador de publicaciones de cada usuario.
Colocación de botones dinámica para hacer un comentario o bien seguir al usuario que la subio(aun no les di funcionalidad).

03/06/2020-Consegui mediante JavaScript filtrar por categorías las fotos que queremos ver en la página principal.
Posicionar las fotos que se muestran en la página de la manera más "bonita" que pude tanto en borraPublicaciones como inicioPublicaciones.
El gran error que me volvió loco  a la hora de subir foto desde la app móvil era una chorrada y es que las fotos que realizamos desde la 
cámara no deja subirla(ya investigué, pero valoré con javi dejar eso más para delante) en cambio cualquier otra sí.
Mejore la inserción de publicaciones desde la app Android y ahora me añade el usuario que lo envía y la categoría.

04/06/2020-Cambiar el archivo php de registro desde el movil porque se me olvido cambiar lo del cifrado de la contraseña.
Diseñando el recyclerView de la pantalla para borrar las publicaciones y que solo aparezcan las  publicaciones del usuario logueado.
Me esta dando problemas mi implmentacion de Restful en mi hosting, consegui solucionarlo.
No se que me pasa con el recycle pero no me muestra lo que deberia, despues de invertir media tarde depurando como un loco usando log y haciendo mil pruebas  sigo sin ver el error,
aun asi tengo sospecha de que mi hosting esta haciendo de las suyas o algo relacionado con el volley(consume el json y apartir e ahi juegas con arraylist y alamcenas 
informacion o lo que te interese)

05/06/2020-Uf porfin consegui solucionar el problema y ademas ahorre muchisimo codigo innecesario tuve que modificar la clase generar un constructor disitnto y en vez de usar el volley 
2 veces para consumir json lo uso solo en la pantalla de inicio y ahi juego con variables estaticas y con pocas lineas de codigo consegui hacer la pantalla de borrar publicaciones
y segun el usuario que se loguea al principio le apareceran solo sus publicaciones.
Mejora del diseño de boton comentarios y seguir.
Consegui borrar publicaciones solo del usuario que se acaba de loguear mediante rest y despues hice un boton en donde se visualizan todas las publicaciones para recargar las publicaciones
y visualizar los actuales.

06/06/2020- Intentando dar funcionalidad al boton de seguir que cuadno se pulsa detecta a quien pertence y mediante determindas consultas a la base 
de datos añade la relación.
Me esta dando bastantes problemas porque al jugar en un mismo sitio con javaScript y php me esta dando problemas.
Desisti y voy a probar haciendolo mediante Rest.
Sigo sin ser capaz debido a que la configuración del POST me da muchos problemas y creo que me conmpensa mas de la otra manera.
Mañana tomo una decision y si sigo sin ser capaz le pedire ayuda a Mila.

07/06/2020-He analizado y me he decantando a hacerlo mediante php.
Porfin consegui insertarlo basicamnete lo que pasaba es que al pasar la variablde JavaScript a Php me daba problemas hasta que encotre la manera adecuada de pasar el valor.
Añadi un contador para saber cuantos te sigue y tambien poder ver tu nombre de usuario,respecto al diseño web es temporal pero ahora me interesa mas hacer lo dificl darle funcionalidad.
Investigando como darle funcionalidad al tema de los comentarios.
Sigo sin ser capaz de poner a funcionar como quiero la ventana modal,mañana seguire intentándolo.

08/06/2020-Después de una larga lucha consegui que me mostrara una ventana modal con el texto determinado asociado a cada boton que tu pinchas de cada imagen.
Pensando como insertar comentarios en la base de datos, lo voy pasar a papel porque esta siendo un lio al tener que jugar con la ventana modal no me doy aclarado.
Me esta dando muchísimos problemas,llevo gran parte de la tarde averiguando porque no me detecta la funcion y lo estoy ejecutando de mil formas distintas.
Borre y volvi empezar pero estoy igual que antes  mañana volvere a retomar y si no le enviare un mensaje a Mila.

09/06/2020- Porfin asi da gusto cambie el metodo de hacerlo y enviar los valores php y ya me funciona.
Ya consegui que el tema de los comentarios me funciona perfectamente pero tengo un problema que es que solo puedo escribir una palabra en el momento que escribo "hola tio" no me 
añade pero si escribo "pep" si y ya investigue bastante y lo voy a dejar mas para delante.
Cada vez que añades una publicación automaticamente te crea un registro relacionado entre el comentario y la publicación.
Ahora me pongo rumbo a hacer lo de seguir y comentario en android.
Me esta dando problemas el detectar en el propio recyclerView las pulsaciones a los botones internos que tiene cada publicación.
Consegui detectar las pulsaciones mas la posicion que pinche y asi despues puedo obtener toda la informacion que quiera.

10/06/2020-Consegui solucionar la pulsación.
Despues de un duro trabajo consegui que cuando tu le das a seguir se añade en la base de datos la relación en si de manera correcta.
Planificar como se va a ver al pulsar botón comentarios de cada publicación.
Consegui hacer que al pulsar comentarios lee los comentarios vinculado a cada publicación determinada consumiendo el restApi.
Ahora me toca pensar como insertar comentarios.
Me esta dando problemas a la hora de la inserción del comentario, mañana sigo intentándolo.

11/06/2020- Continuo con el tema de insertar Comentarios.
Me esta dando uno problemas raros de socket exception y no lo doy solucioando.
Porfin  me funciona y al insertar comentario tambien aparece un @ con el nombre de usuario que inserto ese comentario determinado.
Voy añadir un boton perfil que accede al usuario que se acaba de loguear y muestra una info determinada.
Consegui hacer un floatbutton que cuando pinchas te dice el nombre del usuario,el numero de las publicaciones,el número de los seguidores y de los que sigues.
Ahora me falta darle funcionalidad al boon cerrar sesion y el boton eliminar perfil y salir.

12/06/2020-Consegui darle funcionalidad a los botones y el de borrar sesion y eliminar perfil me funciona pero me da problemas con los usuarios que estan vinculados a x publicaciones.
Porque al borrar perfil tambien quiero borrar todas las publicaciones vinculadas y toda las relaciones de la gente que le sigue o el sigue.
Después de una lucha dura con php consegui meter las sentencias correctas y basicamente apunta a un fragamento PHP online que le pasamos el nombre de usuario y borra todas las entrada
relacioandas con el.
Modificación anteproyecto,cambie lo de visualizaciones por Likes,cada publicación tendra de manera dinamica un boton para poder darle like en caso de que te guste y ese valor
se volcara a una base de datos.

13/06/2020-Dar funcionalidad al boton Like tanto en moviles como en web y implementarlo.
Me esta dando problemas el tema de que si le das una vez no puedes dar like 30 veces mas.
Intenter hacer como en SRV una especia de List<String,String> y asi jugamos con el contains y nos aseguramos pasansole nombre de usuario e id de la publicacion
en este caso pasa a ser un  Map<String,String>.
Visualizacion dinamica de likes de cada publicación apuntando a la base de datos.
No fui capaz de de actualizar el numero de los likes pese a que en la base de datos me va bien,mañana intentare solucionarlo.

14/06/2020- Ya desisti y lo voy a dejar mas para delante porque lo gordo lo hace que es aumentar en +1 los likes en la base de datos sin repeticion, el problema 
es que el contador no muestra la cifra que deberia porque no soy capaz de actualizarlo bien.(Incluso me planteo crear la entidad Like respecto al problema que tengo)
Ahora voy añadir el tema del like en la Web.
Consegui dar Like desde web el problema que tengo ahora es que un usuario X no de like 30 veces a la misma publicacion.
Me pasa una cosa parecida que mediante codigo se me hace imposible controlar quien pincha y quien no,tengo pensando hacer una entidad lo que pasa que si me pongo ahora a hacerla voy a
perder muchisimo tiempo y prefiero ponerme a pulir otras cosas.
Estoy haciedno un acceso a mi perfil para la version web mostrar la informacion bien pero tan pronto accedes sin pulsar nada ya te lo borra y no entiendo porque pese a que lo tengo metido en una funcion.
Porfin lo conseguin no es que fuera complicado si no el problema era como ejecutarlo.

15/06/2020- Actualización anteproyecto.
Revise una cosa y ayer resulta que deje un fallo que solo me borraba el usuario y no las publicaciones y seguidores relacionados.
Aprendiedno a hacer animacion de cargando en Android debido a que hay determinadas partes que tardan(porque tiene que tardar para hacer la carga de datos bien)en cargar 
y poderia generar confusion al usuario.
No estoy siendo capaz de hacer la animación me esta dando muchos problemas mañana continuo y si no pedire ayuda a Javi.


16/06/2020-Lo consegui y me quedo bastante guay el tema de la carga hasta cuando me carga la primera pantalla y justo se quita en el momento adecuado y al añadir publicación tambien.
Solucione unos pequeños problemas de los comentarios.
Diseñando  y relacionando las pantallas del anteproyecto para móvil y tambien haciendolo para web.
Hice algunos apartados del pdf y otros los dejo mas para delante porque me gustaria terminar algunas cosas.

17/06/2020- Pasar toda la app android a ingles y español, cuando el movil del usuario esta en español automaticamente se pone toda la app en español 
en cambio cuando esta en ingles se pone en ingles toda la app.
Intente meterme con el tema de los likes a dejarlo "perfecto" pero nada. Mañana intentare otra vez el tema likes y también revisar el pequeño fallo de los comentarios y entregare todo.










