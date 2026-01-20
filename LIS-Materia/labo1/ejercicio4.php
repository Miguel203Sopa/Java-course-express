<?php
    $a =10;
    $b ="10";
    $c = 20;

    echo ($a == $b) ? "son iguales (valor)" : "No son iguales (valor)";
    echo "\n";
    echo ($a === $b) ? "Son iguales (valor y tipo)" : "No son iguales (valor y tipo)";
    echo "\n";
    echo ($a > 5 && $c < 25) ? "Ambas son verdaderas" : "Una o ambas son falsas";
    echo "\n";
?>