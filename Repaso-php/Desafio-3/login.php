<?php
session_start();
include "conexion.php";

if ($_POST) {
    $user = $_POST['usuario'];
    $pass = $_POST['password'];

    $res = $conexion->query("SELECT * FROM usuarios WHERE usuario='$user'");
    $data = $res->fetch_assoc();

    if ($data) {
        if (password_verify($pass, $data['password'])) {
            $_SESSION['usuario'] = $data['nombre'];
            $_SESSION['id'] = $data['id'];

            header("Location: index.php");
            exit();
        } else {
            echo "PASSWORD INCORRECTA";
        }
    } else {
        echo "USUARIO NO EXISTE";
    }
}
?>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
</head>

<body>
    

<form method="POST">
<input name="usuario" placeholder="Usuario">
<input type="password" name="password" placeholder="Password">
<button>Login</button>
</form>

</body>
</html>