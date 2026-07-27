<?php
include "conexion.php";

$codigo = $_GET['codigo'];

$conexion->query("DELETE FROM inventario_repuestos WHERE codigo=$codigo");

header("Location: index.php");