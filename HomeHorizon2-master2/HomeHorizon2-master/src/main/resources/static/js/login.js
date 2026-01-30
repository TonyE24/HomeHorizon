window.onload = function() {
    var modal = document.getElementById("errorModal");
    if (modal) {
        modal.style.display = "flex"; // Mostrar el modal
    }
};

// Función para cerrar el modal
function cerrarModal() {
    var modal = document.getElementById("errorModal");
    modal.style.display = "none"; // Ocultar el modal
}

// Cerrar el modal si el usuario hace clic fuera de él
window.onclick = function(event) {
    var modal = document.getElementById("errorModal");
    if (event.target == modal) {
        modal.style.display = "none";
    }
};