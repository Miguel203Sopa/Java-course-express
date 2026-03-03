<?php
function comprobarimagen($archivo){
 //La expresión regular analiza si el archivo es de
 //una extensión válida para una imagen gif|jpeg|jpg|png
 //utilizando la función preg_match()
 $patron = "/\.(gif|jpe?g|png)$/i";
 $verificado = preg_match($patron, $archivo);
 $esimagen = $verificado == true ? " (es imagen)" : " (no es imagen)";
 return $esimagen;
 }
?>