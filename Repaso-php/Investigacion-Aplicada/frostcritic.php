<?php
session_start();

/* ==============================
   INICIALIZAR VARIABLES
=================================*/
if (!isset($_SESSION["peliculas"])) {
    $_SESSION["peliculas"] = [];
}

if (!isset($_SESSION["usuario"])) {
    $_SESSION["usuario"] = null;
}

$mensaje = "";

/* ==============================
   REGISTRO
=================================*/
if (isset($_POST["registrar"])) {
    $_SESSION["usuario"] = $_POST["usuario"];
    $mensaje = "Bienvenido a FrostCritic, " . $_SESSION["usuario"];
}

/* ==============================
   AGREGAR PELÍCULA
=================================*/
if (isset($_POST["agregar"])) {

    $pelicula = [
        "titulo" => $_POST["titulo"],
        "genero" => $_POST["genero"],
        "anio" => $_POST["anio"],
        "calificacion" => $_POST["calificacion"],
        "imagen" => $_POST["imagen"]
    ];

    $_SESSION["peliculas"][] = $pelicula;
}

/* ==============================
   ELIMINAR
=================================*/
if (isset($_POST["eliminar"])) {
    $i = $_POST["indice"];
    unset($_SESSION["peliculas"][$i]);
    $_SESSION["peliculas"] = array_values($_SESSION["peliculas"]);
}

/* ==============================
   ACTUALIZAR
=================================*/
if (isset($_POST["actualizar"])) {
    $i = $_POST["indice"];

    $_SESSION["peliculas"][$i] = [
        "titulo" => $_POST["titulo"],
        "genero" => $_POST["genero"],
        "anio" => $_POST["anio"],
        "calificacion" => $_POST["calificacion"],
        "imagen" => $_POST["imagen"]
    ];
}
?>

<!DOCTYPE html>
<html>
<head>
<title>FrostCritic</title>

<style>
body{
    font-family: Arial;
    background: #0f172a;
    color: #e2e8f0;
    margin:0;
}

header{
    background:#1e293b;
    padding:15px;
    text-align:center;
    font-size:24px;
    color:#38bdf8;
}

.container{
    width:90%;
    margin:auto;
    padding:20px;
}

.card{
    background:#1e293b;
    padding:15px;
    margin:15px 0;
    border-radius:8px;
    box-shadow:0 0 10px #0ea5e9;
}

input, select{
    padding:6px;
    margin:5px;
    background:#0f172a;
    color:white;
    border:1px solid #38bdf8;
}

button{
    padding:6px 12px;
    background:#0ea5e9;
    border:none;
    color:white;
    cursor:pointer;
}

button:hover{
    background:#0284c7;
}

.movie{
    display:flex;
    gap:15px;
    align-items:center;
}

.movie img{
    width:120px;
    border-radius:5px;
}
</style>
</head>

<body>

<header>❄ FrostCritic - Críticas de Películas</header>

<div class="container">

<?php if($_SESSION["usuario"] == null) { ?>

<div class="card">
<h3>Registro de Usuario</h3>
<form method="POST">
<input type="text" name="usuario"
       placeholder="Nombre de usuario"
       pattern="[A-Za-z0-9]{4,15}"
       required>
<button name="registrar">Registrarse</button>
</form>
</div>

<?php } else { ?>

<p><?php echo $mensaje; ?></p>

<!-- AGREGAR PELÍCULA -->
<div class="card">
<h3>Agregar Película</h3>
<form method="POST">
<input type="text" name="titulo"
       placeholder="Título"
       pattern="[A-Za-z0-9ÁÉÍÓÚáéíóú ]{2,50}"
       required>

<input type="text" name="genero"
       placeholder="Género"
       pattern="[A-Za-z ]{3,20}"
       required>

<input type="number" name="anio"
       placeholder="Año"
       min="1900" max="2100"
       required>

<input type="number" name="calificacion"
       placeholder="Calificación (1-10)"
       min="1" max="10"
       required>

<input type="text" name="imagen"
       placeholder="URL Imagen"
       required>

<button name="agregar">Agregar</button>
</form>
</div>

<!-- LISTADO -->
<div class="card">
<h3>Películas Registradas</h3>

<?php foreach($_SESSION["peliculas"] as $i => $p) { ?>

<div class="movie">
<img src="<?php echo $p["imagen"]; ?>">
<div>
<strong><?php echo $p["titulo"]; ?></strong><br>
Género: <?php echo $p["genero"]; ?><br>
Año: <?php echo $p["anio"]; ?><br>
Calificación: ⭐ <?php echo $p["calificacion"]; ?>/10

<form method="POST" style="margin-top:5px;">
<input type="hidden" name="indice" value="<?php echo $i; ?>">
<button name="eliminar">Eliminar</button>
</form>

<form method="POST">
<input type="hidden" name="indice" value="<?php echo $i; ?>">
<input type="text" name="titulo" placeholder="Nuevo título" required>
<input type="text" name="genero" placeholder="Nuevo género" required>
<input type="number" name="anio" min="1900" max="2100" required>
<input type="number" name="calificacion" min="1" max="10" required>
<input type="text" name="imagen" placeholder="Nueva URL" required>
<button name="actualizar">Actualizar</button>
</form>

</div>
</div>

<hr style="border:1px solid #334155;">

<?php } ?>

</div>

<?php } ?>

</div>

</body>
</html>