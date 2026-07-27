<?php
include "conexion.php";

$id = $_GET['id'];

$res = $conexion->query("SELECT * FROM bodegas WHERE idbodega=$id");

echo json_encode($res->fetch_assoc());