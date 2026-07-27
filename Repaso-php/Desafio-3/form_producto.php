<?php
include "auth.php";
include "conexion.php";

/* MODO EDICIÓN (opcional) */
$editar = false;

if (isset($_GET['codigo'])) {
    $editar = true;
    $codigo = $_GET['codigo'];

    $res = $conexion->query("SELECT * FROM inventario_repuestos WHERE codigo=$codigo");
    $data = $res->fetch_assoc();
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title><?php echo $editar ? "Editar Producto" : "Nuevo Producto"; ?></title>
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



<h2><?php echo $editar ? "Editar Producto" : "Agregar Nuevo Producto"; ?></h2>



<br><br>

<form method="POST" action="<?php echo $editar ? 'actualizar.php' : 'guardar.php'; ?>">

<input type="number" name="codigo" placeholder="Código"
value="<?php echo $editar ? $data['codigo'] : ''; ?>" required>

<br><br>

<input type="text" name="nombre" placeholder="Nombre"
value="<?php echo $editar ? $data['nombre_repuesto'] : ''; ?>" required>

<br><br>

<input type="text" name="descripcion" placeholder="Descripción"
value="<?php echo $editar ? $data['descripcion'] : ''; ?>">

<br><br>

<input type="text" name="marca" placeholder="Marca"
value="<?php echo $editar ? $data['marca'] : ''; ?>">

<br><br>

<input type="text" name="modelo" placeholder="Modelo compatible"
value="<?php echo $editar ? $data['modelo_compatible'] : ''; ?>">

<br><br>

<input type="number" name="stock" placeholder="Stock"
value="<?php echo $editar ? $data['cantidad_stock'] : ''; ?>" required>

<br><br>

<input type="number" step="0.01" name="precio" placeholder="Precio unitario"
value="<?php echo $editar ? $data['precio_unitario'] : ''; ?>" required>

<br><br>

<input type="number" step="0.01" name="total" placeholder="Precio total"
value="<?php echo $editar ? $data['precio_total'] : ''; ?>">

<br><br>

<input type="text" name="proveedor" placeholder="Proveedor"
value="<?php echo $editar ? $data['proveedor'] : ''; ?>">

<br><br>

<input type="text" name="ubicacion" placeholder="Ubicación"
value="<?php echo $editar ? $data['ubicacion'] : ''; ?>">

<br><br>

<input type="date" name="fecha"
value="<?php echo $editar ? $data['fecha_ingreso'] : ''; ?>">

<br><br>

<input type="text" name="url" placeholder="URL de imagen"
value="<?php echo $editar ? $data['fotografia_url'] : ''; ?>">

<br><br>

<button>
<?php echo $editar ? "Actualizar Producto" : "Guardar Producto"; ?>
</button>

</form>

</body>
</html>