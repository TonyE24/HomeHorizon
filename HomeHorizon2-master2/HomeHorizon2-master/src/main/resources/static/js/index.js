window.onload = function () {
    // Datos iniciales del gráfico de pastel
    const datos = {
        labels: ['junio', 'julio', 'agosto'],
        datasets: [{
            data: [30, 50, 20], // Valores iniciales
            backgroundColor: ["#f7885e", '#a7d36b', '#b0f3f0'],
        }]
    };

    // Crear el gráfico de pastel
    const ctx = document.getElementById('miGraficoPastel').getContext('2d');
    const miGraficoPastel = new Chart(ctx, {
        type: 'pie',
        data: datos
    });

    // Función para actualizar el gráfico de pastel dinámicamente
    function actualizarGraficoPastel(nuevosDatos) {
        miGraficoPastel.data.datasets[0].data = nuevosDatos;
        miGraficoPastel.update();
    }

    // Actualización de datos dinámicamente después de 3 segundos
    setTimeout(() => {
        const nuevosDatos = [40, 35, 25]; // Nuevos valores
        actualizarGraficoPastel(nuevosDatos);
    }, 3000);

    // Datos iniciales del gráfico de barras
    const datosBarras = {
        labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo'],
        datasets: [{
            label: 'Ventas',
            data: [65, 59, 80, 81, 56], // Valores iniciales de las barras
            backgroundColor: 'rgba(75, 192, 192, 0.2)',
            borderColor: 'rgba(75, 192, 192, 1)',
            borderWidth: 1
        }]
    };

    // Crear el gráfico de barras
    const ctd = document.getElementById('miGraficoBarras').getContext('2d');
    const miGraficoBarras = new Chart(ctd, {
        type: 'bar', // Tipo de gráfico: Barras
        data: datosBarras,
        options: {
            scales: {
                y: {
                    beginAtZero: true // Asegura que el eje Y comience en 0
                }
            }
        }
    });

    // Función para actualizar los valores de las barras dinámicamente
    function actualizarGraficoBarras(nuevosDatos) {
        miGraficoBarras.data.datasets[0].data = nuevosDatos; // Actualiza los datos
        miGraficoBarras.update(); // Redibuja el gráfico con los nuevos valores
    }

    // Actualización de datos dinámicamente después de 5 segundos
    setTimeout(() => {
        const nuevosDatos = [75, 65, 90, 95, 60]; // Nuevos valores
        actualizarGraficoBarras(nuevosDatos); // Actualiza el gráfico
    }, 5000);
};

