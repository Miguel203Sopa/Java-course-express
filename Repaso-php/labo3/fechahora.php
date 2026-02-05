<!DOCTYPE html>
<html lang="es">
<head>
<title>Fecha y hora del Sistema</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0,
maximum-scale=1.0, minimum-scale=1.0" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<?php
// Establecer la zona horaria
date_default_timezone_set("America/El_Salvador");
$dia = date("w");
switch ($dia) {
case 0: $dia = "Domingo"; break;
case 1: $dia = "Lunes"; break;
case 2: $dia = "Martes"; break;
case 3: $dia = "Miércoles"; break;
case 4: $dia = "Jueves"; break;
case 5: $dia = "Viernes"; break;
case 6: $dia = "Sábado"; break;
}
$mes = date("n");
switch ($mes) {
case 1: $mes = "Enero"; break;
case 2: $mes = "Febrero"; break;
case 3: $mes = "Marzo"; break;
case 4: $mes = "Abril"; break;
case 5: $mes = "Mayo"; break;
case 6: $mes = "Junio"; break;
case 7: $mes = "Julio"; break;
case 8: $mes = "Agosto"; break;
case 9: $mes = "Septiembre"; break;
case 10: $mes = "Octubre"; break;
case 11: $mes = "Noviembre"; break;
case 12: $mes = "Diciembre"; break;
}
$numero = date("j");
$anio = date("Y");
$hora = date("g:i a");
printf("<header>\n");
printf("\t<div class=\"container mt-5\">\n");
printf("\t\t<div class=\"card shadow\">\n");
printf("\t\t\t<div class=\"card-body text-center\">\n");
printf("\t\t\t\t<p class=\"h4\">Hoy es %s, %d de %s del %d</p>\n", $dia, $numero, $mes, $anio);
printf("\t\t\t\t<p class=\"h5\">Son las: %s</p>\n", $hora);
printf("\t\t\t</div>\n");
printf("\t\t</div>\n");
printf("\t</div>\n");
printf("</header>\n");
?>
<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
