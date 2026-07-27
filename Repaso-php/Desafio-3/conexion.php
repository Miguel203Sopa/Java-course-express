<?php
$conexion = new mysqli("localhost", "root", "", "ultra_repuestos");

if ($conexion->connect_error) {
    die("Error de conexión: " . $conexion->connect_error);
}
?>

