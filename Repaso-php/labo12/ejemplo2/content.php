<?php
 $host = "localhost";
 $user = "root"; //Cambiar por el usuario de la base de datos en su servidor
 $pass = "j"; //Cambiar por la contraseña de la base de datos en su servidor
 $db = "prensa";
 //Establecer conexión con el servidor MySQL
 $cn = new mysqli($host, $user, $pass, $db);
 if($cn->connect_errno){
 printf("Falló la conexión: %s\n", $cn->connect_error);
 exit(0);
 }
 $tipo = isset($_GET['content']) ? $_GET['content'] : 0;
 if($tipo != 0){
 $qr = "SELECT titulonoticia, textonoticia, imgnoticia FROM
noticia ";
 $qr .= "WHERE idnota = $tipo";
 $rs = $cn->query($qr);
 while($row = $rs->fetch_object()){
 $info = "<div id=\"titulo\">\n<h2>\n{$row->titulonoticia}</h2>\n</div>\n";
 $info .= "<div id=\"texto\">\n<p>\n{$row->textonoticia}\n";
 $info .= "<img src=\"{$row->imgnoticia}\n\" />\n";
 $info .= "</p>\n</div>\n";
 }
 if (!$cn->set_charset("utf8")) {
 printf("Error cambiando el juego de caracteres utf8: %s\n",
$cn->error);
 } else {
 printf($info, $cn->character_set_name());
 }

 }
 ?>