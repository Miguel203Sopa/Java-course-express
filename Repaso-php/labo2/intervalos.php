<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Análisis de una Serie de Números</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
<h1 class="text-center">Análisis de una Serie de Números</h1>
<form method="POST" class="mt-4">
<div class="mb-3">
<label for="numbers" class="form-label">Ingresa números separados por comas:</label>
<input type="text" name="numbers" id="numbers" class="form-control" placeholder="Ejemplo:
5,12,8,7,3" required>
</div>
<button type="submit" class="btn btn-primary w-100">Analizar</button>
</form>
<?php if ($_SERVER['REQUEST_METHOD'] === 'POST'): ?>
<div class="mt-4">
<?php
$input = $_POST['numbers'];
$numbers = array_map('intval', explode(',', $input));
$min = PHP_INT_MAX;
$max = PHP_INT_MIN;
$sum = 0;
$even_count = 0;
$index = 0;
do {
$current = $numbers[$index];
$sum += $current;
if ($current < $min) {
$min = $current;
}
if ($current > $max) {
$max = $current;
}
if ($current % 2 === 0) {
$even_count++;
}
$index++;
} while ($index < count($numbers));
echo "<div class='alert alert-success'>";
echo "<p><strong>Números ingresados:</strong> " . implode(', ', $numbers) . "</p>";
echo "<p><strong>Valor menor:</strong> $min</p>";
echo "<p><strong>Valor mayor:</strong> $max</p>";
echo "<p><strong>Total de números pares:</strong> $even_count</p>";
echo "<p><strong>Suma total:</strong> $sum</p>";
echo "</div>";
?>
</div>
<?php endif; ?>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>