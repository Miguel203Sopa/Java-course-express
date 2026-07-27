<?php
include "auth.php";
include "conexion.php";



/* INSERTAR */
if ($_POST) {
    $conexion->query("
    INSERT INTO bodegas (nombre, descripcion, responsable, departamento, municipio, direccion, estado)
    VALUES (
        '$_POST[nombre]',
        '$_POST[descripcion]',
        '$_POST[responsable]',
        '$_POST[departamento]',
        '$_POST[municipio]',
        '$_POST[direccion]',
        '$_POST[estado]'
    )
    ");
}

/* ELIMINAR */
if (isset($_GET['eliminar'])) {
    $id = $_GET['eliminar'];
    $conexion->query("DELETE FROM bodegas WHERE idbodega=$id");
}
?>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bodegas</title>
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



<h2>Gestión de Bodegas</h2>


<hr>

<!-- FORMULARIO -->
<h3>Agregar Bodega</h3>

<form method="POST">

<input name="nombre" placeholder="Nombre" required><br><br>
<input name="descripcion" placeholder="Descripción"><br><br>
<input name="responsable" placeholder="Responsable"><br><br>
<input name="departamento" placeholder="Departamento"><br><br>
<input name="municipio" placeholder="Municipio"><br><br>
<input name="direccion" placeholder="Dirección"><br><br>
<input name="estado" placeholder="Estado (Activa/Inactiva)"><br><br>

<button>Guardar</button>

</form>

<hr>

<!-- LISTADO -->
<h3>Listado de Bodegas</h3>

<table border="1">
<tr>
<th>ID</th>
<th>Nombre</th>
<th>Responsable</th>
<th>Ubicación</th>
<th>Estado</th>
<th>Acciones</th>
</tr>

<?php
$res = $conexion->query("SELECT * FROM bodegas");

while($row = $res->fetch_assoc()){
?>
<tr>
<td><?php echo $row['idbodega']; ?></td>
<td><?php echo $row['nombre']; ?></td>
<td><?php echo $row['responsable']; ?></td>
<td><?php echo $row['departamento'] . ", " . $row['municipio']; ?></td>
<td><?php echo $row['estado']; ?></td>

<td>
<a href="bodegas.php?eliminar=<?php echo $row['idbodega']; ?>"
onclick="return confirm('¿Eliminar bodega?')">
🗑 Eliminar


</a>

<button onclick="abrirModalBodega(<?php echo $row['idbodega']; ?>)">
✏ Editar
</button>
</td>

</tr>



<?php } ?>

</table>

<div id="modalBodega" style="display:none; position:fixed; top:20%; left:30%; background:white; padding:20px; border:1px solid black;">

<h3>Editar Bodega</h3>

<form id="formBodega">

<input type="hidden" name="idbodega" id="idbodega">

<input type="text" name="nombre" id="nombre"><br><br>
<input type="text" name="descripcion" id="descripcion"><br><br>
<input type="text" name="responsable" id="responsable"><br><br>
<input type="text" name="departamento" id="departamento"><br><br>
<input type="text" name="municipio" id="municipio"><br><br>
<input type="text" name="direccion" id="direccion"><br><br>
<input type="text" name="estado" id="estado"><br><br>

<button type="submit">Actualizar</button>
<button type="button" onclick="cerrarModalBodega()">Cerrar</button>

</form>
</div>

<script>
function abrirModalBodega(id){
    fetch("obtener_bodega.php?id=" + id)
    .then(res => res.json())
    .then(data => {

        document.getElementById("idbodega").value = data.idbodega;
        document.getElementById("nombre").value = data.nombre;
        document.getElementById("descripcion").value = data.descripcion;
        document.getElementById("responsable").value = data.responsable;
        document.getElementById("departamento").value = data.departamento;
        document.getElementById("municipio").value = data.municipio;
        document.getElementById("direccion").value = data.direccion;
        document.getElementById("estado").value = data.estado;

        document.getElementById("modalBodega").style.display = "block";
    });
}

function cerrarModalBodega(){
    document.getElementById("modalBodega").style.display = "none";
}

document.getElementById("formBodega").addEventListener("submit", function(e){
    e.preventDefault();

    let formData = new FormData(this);

    fetch("actualizar_bodega.php", {
        method: "POST",
        body: formData
    })
    .then(() => {
        alert("Bodega actualizada");
        location.reload();
    });
});
</script>
<link rel="stylesheet" href="styles.css">

</body>
</html>