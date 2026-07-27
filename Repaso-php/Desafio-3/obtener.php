<?php
include "conexion.php";

$codigo = $_GET['codigo'];

$res = $conexion->query("SELECT * FROM inventario_repuestos WHERE codigo=$codigo");

echo json_encode($res->fetch_assoc());