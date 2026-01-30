document.getElementById('searchButton').addEventListener('click', function() {
    var input = document.getElementById('searchInput').value.toLowerCase();
    var table = document.getElementById('agentsTable');
    var rows = table.getElementsByTagName('tr');

    // Verifica si el input está vacío
    if (input === "") {
        // Mostrar todas las filas si el input está vacío
        for (var i = 1; i < rows.length; i++) { // Comienza desde 1 para evitar el encabezado
            rows[i].style.display = ''; // Muestra la fila
        }
        return; // Sale de la función si el input está vacío
    }

    // Iterar sobre las filas de la tabla
    for (var i = 1; i < rows.length; i++) { // Comienza desde 1 para evitar el encabezado
        var cells = rows[i].getElementsByTagName('td');
        var found = false;

        // Verificar cada celda en la fila
        for (var j = 0; j < cells.length; j++) {
            if (cells[j]) {
                var text = cells[j].innerText.toLowerCase();
                if (text.includes(input)) {
                    found = true;
                    break;
                }
            }
        }

        // Mostrar u ocultar la fila
        rows[i].style.display = found ? '' : 'none';
    }
});