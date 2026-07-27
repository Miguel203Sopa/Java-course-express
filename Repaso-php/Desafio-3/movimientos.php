<?php
include "auth.php";
include "conexion.php";

$result = $conexion->query("SELECT * FROM movimientos");
?>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movimientos</title>
<link rel="stylesheet" href="styles.css">
</head>

<body>

<div class="header">
    <div>Ultra Repuestos</div>

    <div>
        <?php echo $_SESSION['usuario']; ?>
        <a href="index.php">Inicio</a>
        <a href="form_producto.php">Producto</a>
        <a href="bodegas.php">Bodegas</a>
        <a href="movimientos.php">Movimientos</a>
        <a href="traslados.php">Traslados</a>
        <a href="logout.php">Cerrar sesión</a>
    </div>
</div>

<div class="container">

<h2>Historial de Movimientos</h2>

<table>
<tr>
    <th>Usuario</th>
    <th>Producto</th>
    <th>Bodega Salida</th>
    <th>Bodega Entrada</th>
    <th>Cantidad</th>
    <th>Fecha</th>
</tr>

<?php while($row = $result->fetch_assoc()){ ?>
<tr>
    <td><?php echo $row['idusuario']; ?></td>
    <td><?php echo $row['nombreproducto']; ?></td>
    <td><?php echo $row['bodega_salida']; ?></td>
    <td><?php echo $row['bodega_entrada']; ?></td>
    <td><?php echo $row['cantidad']; ?></td>
    <td><?php echo $row['fecha']; ?></td>
</tr>
<?php } ?>

</table>

</div>

</body>
</html>