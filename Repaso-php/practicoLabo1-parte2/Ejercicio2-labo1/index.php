<?php
$resultados = [];
$unidad = "";
$cantidad = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $unidad = $_POST["unidad"];
    $cantidad = floatval($_POST["cantidad"]);

    // Convertimos todo primero a metros (unidad base)
    switch ($unidad) {
        case "metros":
            $metros = $cantidad;
            break;
        case "pulgadas":
            $metros = $cantidad * 0.0254;
            break;
        case "yardas":
            $metros = $cantidad * 0.9144;
            break;
        case "pies":
            $metros = $cantidad * 0.3048;
            break;
    }

    // Convertimos desde metros al resto
    $resultados["Metros"] = $metros;
    $resultados["Pulgadas"] = $metros / 0.0254;
    $resultados["Yardas"] = $metros / 0.9144;
    $resultados["Pies"] = $metros / 0.3048;

    // Quitamos la unidad seleccionada (para no repetir)
    unset($resultados[ucfirst($unidad)]);
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Conversor de Longitudes</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<div class="container">
    <h2>Conversor de Longitudes</h2>

    <form method="POST" onsubmit="return validarFormulario()">
        <label>Seleccione la unidad:</label>
        <select name="unidad" id="unidad" required>
            <option value="">-- Seleccione --</option>
            <option value="metros">Metros</option>
            <option value="pulgadas">Pulgadas</option>
            <option value="yardas">Yardas</option>
            <option value="pies">Pie</option>
        </select>

        <label>Ingrese la cantidad:</label>
        <input type="number" step="any" name="cantidad" id="cantidad" required>

        <button type="submit">Convertir</button>
    </form>

    <?php if (!empty($resultados)): ?>
        <h3><?php echo ucfirst($unidad) . ": " . $cantidad; ?></h3>

        <table>
            <tr>
                <th>Unidad</th>
                <th>Resultado</th>
            </tr>

            <?php foreach ($resultados as $u => $valor): ?>
                <tr>
                    <td><?php echo $u; ?></td>
                    <td><?php echo number_format($valor, 4); ?></td>
                </tr>
            <?php endforeach; ?>
        </table>
    <?php endif; ?>
</div>

<script src="script.js"></script>
</body>
</html>