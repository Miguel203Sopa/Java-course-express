function validarFormulario() {
    let unidad = document.getElementById("unidad").value;
    let cantidad = document.getElementById("cantidad").value;

    if (unidad === "") {
        alert("Seleccione una unidad.");
        return false;
    }

    if (cantidad === "" || cantidad <= 0) {
        alert("Ingrese una cantidad válida mayor que 0.");
        return false;
    }

    return true;
}