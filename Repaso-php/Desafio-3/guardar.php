<?php
include "conexion.php";

$codigo = $_POST['codigo'];
$nombre = $_POST['nombre'];
$descripcion = $_POST['descripcion'];
$marca = $_POST['marca'];
$modelo = $_POST['modelo'];
$stock = $_POST['stock'];
$precio = $_POST['precio'];
$total = $_POST['total'];
$proveedor = $_POST['proveedor'];
$ubicacion = $_POST['ubicacion'];
$fecha = $_POST['fecha'];
$url = $_POST['url'];

$sql = "INSERT INTO inventario_repuestos 
(codigo, nombre_repuesto, descripcion, marca, modelo_compatible, cantidad_stock, precio_unitario, precio_total, proveedor, ubicacion, fecha_ingreso, fotografia_url)
VALUES (
$codigo,
'$nombre',
'$descripcion',
'$marca',
'$modelo',
$stock,
$precio,
$total,
'$proveedor',
'$ubicacion',
'$fecha',
'$url'
)";

$conexion->query($sql);

/* Obtener ID de bodega por defecto */
$res = $conexion->query("SELECT idbodega FROM bodegas WHERE nombre='Almacen La Union'");
$bodega = $res->fetch_assoc();

/* Insertar en inventario por bodega */
$conexion->query("
INSERT INTO inventario_bodega (codigo_producto, idbodega, cantidad)
VALUES ($codigo, {$bodega['idbodega']}, $stock)
");

header("Location: index.php");

?>