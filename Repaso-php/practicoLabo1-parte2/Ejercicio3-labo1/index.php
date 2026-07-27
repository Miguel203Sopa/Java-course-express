<?php
$resultado = "";
if ($_SERVER["REQUEST_METHOD"] == "POST") {

    $vehiculo = $_POST["vehiculo"];
    $distancia = floatval($_POST["distancia"]);

    // Tabla de consumos (Km/Gal)
    $consumos = [
        "Camion 5 Ton" => 14,
        "Camion 3 Ton" => 16,
        "Pickup" => 28,
        "Panel" => 31,
        "Moto" => 45
    ];

    $rendimiento = $consumos[$vehiculo];

    // Cálculo de galones consumidos
    $galones = $distancia / $rendimiento;

    $resultado = "En $vehiculo recorrerá $distancia Km consumiendo "
               . number_format($galones, 2) . " Galones.";
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Consumo de Combustible</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<div class="container">
    <h2>Transportes Salvador</h2>
    <h3>Cálculo de Consumo de Combustible</h3>

    <form method="POST" onsubmit="return validar()">
        <label>Seleccione el Vehículo:</label>
        <select name="vehiculo" id="vehiculo" required>
            <option value="">-- Seleccione --</option>
            <option value="Camion 5 Ton">Camión 5 Ton</option>
            <option value="Camion 3 Ton">Camión 3 Ton</option>
            <option value="Pickup">Pickup</option>
            <option value="Panel">Panel</option>
            <option value="Moto">Moto</option>
        </select>

        <label>Distancia a recorrer (Km):</label>
        <input type="number" step="any" name="distancia" id="distancia" required>

        <button type="submit">Calcular Consumo</button>
    </form>

    <?php if ($resultado != ""): ?>
        <div class="resultado">
            <?php echo $resultado; ?>
        </div>
    <?php endif; ?>

    <h4>Tabla de Rendimiento</h4>
    <table>
        <tr>
            <th>Vehículo</th>
            <th>Consumo (Km/Gal)</th>
        </tr>
        <tr><td>Camión 5 Ton</td><td>14</td></tr>
        <tr><td>Camión 3 Ton</td><td>16</td></tr>
        <tr><td>Pickup</td><td>28</td></tr>
        <tr><td>Panel</td><td>31</td></tr>
        <tr><td>Moto</td><td>45</td></tr>
    </table>
</div>

<script src="script.js"></script>
</body>
</html>