<!DOCTYPE html>
<html lang="es">
<head>
<title>Detector de Lenguaje del Navegador</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div id="wrapper" class="container mt-5">
<header class="text-center mb-4">
<h1 class="text-primary">Idioma del navegador</h1>
</header>
<section class="card shadow-lg border-0 p-4">
<div class="card-body">
<?php
//Antes de nada introducimos mensajes en forma de variables
$espanol = "Hola";
$ingles = "Hello";
$aleman = "Hallo";
$frances = "Bonjour";
$italiano = "Ciao";
$portugues = "Olá";
//Ahora leemos del navegador cuál es su lengua oficial
$completo = $_SERVER["HTTP_ACCEPT_LANGUAGE"];
$idioma = substr($_SERVER["HTTP_ACCEPT_LANGUAGE"],0,2);
//$idioma=substr($HTTP_ACCEPT_LANGUAGE,0,2);
//Formulamos las posibilidades que se pueden dar
echo "<p class='alert alert-primary'>Lenguaje completo: " . $completo . "<br>Lenguaje principal: " .
$idioma . "</p>\n";
if($idioma == "es"){
echo '<p class="alert alert-success">';
printf ("El lenguaje que se está utilizando en el navegador es el Español: %s </p>\n", $espanol);
}
elseif($idioma == "fr"){
echo '<p class="alert alert-info">';
printf ("El lenguaje que se está utilizando en el navegador es el Francés: %s </p>\n", $frances);
}
elseif($idioma == "en"){
echo '<p class="alert alert-warning">';
printf ("El lenguaje que se está utilizando en el navegador es el Inglés: %s </p>\n", $ingles);
}
elseif($idioma == "de"){
echo '<p class="alert alert-danger">';
printf ("El lenguaje que se está utilizando en el navegador es el Alemán: %s </p>", $aleman);
}
elseif($idioma == "it"){
echo '<p class="alert alert-secondary">';
printf ("El lenguaje que se está utilizando en el navegador es el Italiano: %s </p>\n", $italiano);
}
elseif($idioma == "pt"){
echo '<p class="alert alert-dark">';
printf ("El lenguaje que se está utilizando en el navegador es el Portugués: %s </p>", $portugues);
}
else{
echo '<p class="alert alert-light">';
echo "El idioma del navegador es desconocido.</p>\n";
}
?>
</div>
</section>
</div>
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
