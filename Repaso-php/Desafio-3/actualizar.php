<?php
include "conexion.php";

$sql = "UPDATE inventario_repuestos SET
nombre_repuesto='$_POST[nombre]',
descripcion='$_POST[descripcion]',
marca='$_POST[marca]',
modelo_compatible='$_POST[modelo]',
cantidad_stock=$_POST[stock],
precio_unitario=$_POST[precio],
precio_total=$_POST[total],
proveedor='$_POST[proveedor]',
ubicacion='$_POST[ubicacion]',
fecha_ingreso='$_POST[fecha]',
fotografia_url='$_POST[url]'
WHERE codigo=$_POST[codigo]";

$conexion->query($sql);


header("Location: index.php");
?>

<?php include "auth.php"; ?>

<div style="position:absolute; right:20px; top:10px;">
    Bienvenido, <?php echo $_SESSION['usuario']; ?>
    <a href="logout.php">Cerrar sesión</a>
</div>


