document.getElementById('inputImagen').addEventListener('change', function(event) {
    const archivo = event.target.files[0];

    if (archivo) {
        const lector = new FileReader(); 

        lector.onload = function(e) {
            const img = document.getElementById('imagenSeleccionada');
            img.src = e.target.result; 
            img.style.display = 'block'; 
        };

        lector.readAsDataURL(archivo);
    }
});
