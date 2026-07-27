<?php
include "conexion.php";
session_start();

$producto = $_POST['producto'];
$salida = $_POST['bodega_salida'];
$entrada = $_POST['bodega_entrada'];
$cantidad = $_POST['cantidad'];
$usuario = $_SESSION['id'];

/* 1. Restar stock */
$conexion->query("
UPDATE inventario_bodega 
SET cantidad = cantidad - $cantidad 
WHERE codigo_producto=$producto AND idbodega=$salida
");

/* 2. Sumar stock */
$conexion->query("
UPDATE inventario_bodega 
SET cantidad = cantidad + $cantidad 
WHERE codigo_producto=$producto AND idbodega=$entrada
");

/* 3. Registrar bitácora */
$conexion->query("
INSERT INTO movimientos 
(idusuario, idproducto, nombreproducto, bodega_salida, bodega_entrada, responsable, cantidad)
VALUES (
$usuario,
$producto,
(SELECT nombre_repuesto FROM inventario_repuestos WHERE codigo=$producto),
$salida,
$entrada,
'$_SESSION[usuario]',
$cantidad
)
");

header("Location: movimientos.php");