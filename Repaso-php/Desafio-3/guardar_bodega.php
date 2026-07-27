<?php
include "conexion.php";

$sql = "INSERT INTO bodegas 
(nombre, descripcion, responsable, departamento, municipio, direccion, estado)
VALUES (
'$_POST[nombre]',
'$_POST[descripcion]',
'$_POST[responsable]',
'$_POST[departamento]',
'$_POST[municipio]',
'$_POST[direccion]',
'$_POST[estado]'
)";

$conexion->query($sql);

header("Location: bodegas.php");
?>