<?php
include "auth.php";
include "conexion.php";
?>
<link rel="stylesheet" href="styles.css">
<h2>Traslado de Productos</h2>

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


<form method="POST" action="mover.php">

<label>Producto:</label>
<select name="producto">
<?php
$res = $conexion->query("SELECT codigo, nombre_repuesto FROM inventario_repuestos");
while($row = $res->fetch_assoc()){
    echo "<option value='{$row['codigo']}'>{$row['nombre_repuesto']}</option>";
}
?>
</select>

<br><br>

<label>Bodega de salida:</label>
<select name="bodega_salida">
<?php
$res = $conexion->query("SELECT * FROM bodegas");
while($row = $res->fetch_assoc()){
    echo "<option value='{$row['idbodega']}'>{$row['nombre']}</option>";
}
?>
</select>

<br><br>

<label>Bodega de entrada:</label>
<select name="bodega_entrada">
<?php
$res = $conexion->query("SELECT * FROM bodegas");
while($row = $res->fetch_assoc()){
    echo "<option value='{$row['idbodega']}'>{$row['nombre']}</option>";
}
?>
</select>

<br><br>

<label>Cantidad:</label>
<input type="number" name="cantidad" required>

<br><br>

<button>Trasladar</button>

</form>