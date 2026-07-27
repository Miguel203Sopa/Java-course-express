<?php
include "auth.php";
include "conexion.php";
?>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Inventario</title>
<link rel="stylesheet" href="styles.css">

<style>
table { border-collapse: collapse; width: 100%; }
th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }

/* OVERLAY */
.modal-overlay {
    display: none;
    position: fixed;
    width: 100%;
    height: 100%;
    background: rgba(0,0,0,0.6);
    top: 0;
    left: 0;
    z-index: 999;
}

/* MODAL */
.modal {
    display: none;
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    
    width: 420px;
    max-height: 80vh;
    
    background: white;
    padding: 20px;
    border-radius: 10px;
    
    overflow-y: auto; /* SCROLL */
    
    box-shadow: 0px 5px 20px rgba(0,0,0,0.3);
    z-index: 1000;
}

.modal input {
    width: 100%;
    padding: 8px;
    margin-bottom: 10px;
}

.modal h3 {
    text-align: center;
}
</style>

</head>
<body>

<h2>Inventario de Repuestos</h2>

<div class="header">
    <div>Ultra Repuestos</div>

    <div>
        Bienvenido, <?php echo $_SESSION['usuario']; ?> |
        <a href="index.php">Inicio</a>
        <a href="form_producto.php">Producto</a>
        <a href="bodegas.php">Bodegas</a>
        <a href="movimientos.php">Movimientos</a>
        <a href="traslados.php">Traslados</a>
        <a href="logout.php">Cerrar sesión</a>
    </div>
</div>

<br><br>

<table>
<tr>
    <th>Imagen</th>
    <th>Código</th>
    <th>Nombre</th>
    <th>Marca</th>
    <th>Stock</th>
    <th>Acciones</th>
</tr>

<?php
$result = $conexion->query("SELECT * FROM inventario_repuestos");

while($row = $result->fetch_assoc()){
?>
<tr>
    <td>
    <?php if($row['fotografia_url']){ ?>
        <img src="<?php echo $row['fotografia_url']; ?>" width="80">
    <?php } else { ?>
        sin imagen
    <?php } ?>
    </td>

    <td><?php echo $row['codigo']; ?></td>
    <td><?php echo $row['nombre_repuesto']; ?></td>
    <td><?php echo $row['marca']; ?></td>
    <td><?php echo $row['cantidad_stock']; ?></td>

    <td>
        <button onclick="abrirModal(<?php echo $row['codigo']; ?>)">
            ✏ Editar
        </button>

        <a href="eliminar.php?codigo=<?php echo $row['codigo']; ?>"
           onclick="return confirm('¿Seguro que quieres eliminar este producto?')">
            🗑 Eliminar
        </a>
    </td>
</tr>
<?php } ?>
</table>

<!-- OVERLAY -->
<div id="overlay" class="modal-overlay" onclick="cerrarModal()"></div>

<!-- MODAL -->
<div id="modal" class="modal">

<h3>Editar Producto</h3>

<form id="formEditar">

<input type="hidden" name="codigo" id="codigo">

<input type="text" name="nombre" id="nombre" placeholder="Nombre">
<input type="text" name="descripcion" id="descripcion" placeholder="Descripción">
<input type="text" name="marca" id="marca" placeholder="Marca">
<input type="text" name="modelo" id="modelo" placeholder="Modelo">
<input type="number" name="stock" id="stock" placeholder="Stock">
<input type="number" step="0.01" name="precio" id="precio" placeholder="Precio">
<input type="number" step="0.01" name="total" id="total" placeholder="Total">
<input type="text" name="proveedor" id="proveedor" placeholder="Proveedor">
<input type="text" name="ubicacion" id="ubicacion" placeholder="Ubicación">
<input type="date" name="fecha" id="fecha">
<input type="text" name="url" id="url" placeholder="URL imagen">

<button type="submit">Actualizar</button>
<button type="button" onclick="cerrarModal()">Cerrar</button>

</form>

</div>

<!-- JS -->
<script>
function abrirModal(codigo){
    fetch("obtener.php?codigo=" + codigo)
    .then(res => res.json())
    .then(data => {

        document.getElementById("codigo").value = data.codigo;
        document.getElementById("nombre").value = data.nombre_repuesto;
        document.getElementById("descripcion").value = data.descripcion;
        document.getElementById("marca").value = data.marca;
        document.getElementById("modelo").value = data.modelo_compatible;
        document.getElementById("stock").value = data.cantidad_stock;
        document.getElementById("precio").value = data.precio_unitario;
        document.getElementById("total").value = data.precio_total;
        document.getElementById("proveedor").value = data.proveedor;
        document.getElementById("ubicacion").value = data.ubicacion;
        document.getElementById("fecha").value = data.fecha_ingreso;
        document.getElementById("url").value = data.fotografia_url;

        document.getElementById("modal").style.display = "block";
        document.getElementById("overlay").style.display = "block";
    });
}

function cerrarModal(){
    document.getElementById("modal").style.display = "none";
    document.getElementById("overlay").style.display = "none";
}

document.getElementById("formEditar").addEventListener("submit", function(e){
    e.preventDefault();

    let formData = new FormData(this);

    fetch("actualizar.php", {
        method: "POST",
        body: formData
    })
    .then(() => {
        alert("Actualizado correctamente");
        location.reload();
    });
});
</script>

</body>
</html>