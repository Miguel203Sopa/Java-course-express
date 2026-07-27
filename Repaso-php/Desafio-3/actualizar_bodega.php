<?php
include "conexion.php";

$sql = "UPDATE bodegas SET
nombre='$_POST[nombre]',
descripcion='$_POST[descripcion]',
responsable='$_POST[responsable]',
departamento='$_POST[departamento]',
municipio='$_POST[municipio]',
direccion='$_POST[direccion]',
estado='$_POST[estado]'
WHERE idbodega=$_POST[idbodega]";

$conexion->query($sql);
?>