function validar() {
    let vehiculo = document.getElementById("vehiculo").value;
    let distancia = document.getElementById("distancia").value;

    if (vehiculo === "") {
        alert("Seleccione un vehículo.");
        return false;
    }

    if (distancia === "" || distancia <= 0) {
        alert("Ingrese una distancia válida.");
        return false;
    }

    return true;
}