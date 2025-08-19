// Espera a que todo el contenido del DOM esté cargado antes de ejecutar el script.
document.addEventListener('DOMContentLoaded', () => {

    // --- LÓGICA DE LA ANIMACIÓN DE ESTRELLAS ---

    /**
     * Crea un número determinado de estrellas y las añade al contenedor.
     * @param {number} count - El número de estrellas a crear.
     */
    function createStars(count) {
        const container = document.getElementById('stars-container');
        if (!container) return; // Si no hay contenedor, no hace nada.

        for (let i = 0; i < count; i++) {
            const star = document.createElement('div');
            star.className = 'star';

            // Asigna tamaño, posición y retardo de animación aleatorios.
            const size = Math.random() * 2 + 1; // Estrellas de 1px a 3px
            star.style.width = `${size}px`;
            star.style.height = `${size}px`;
            star.style.top = `${Math.random() * 100}%`;
            star.style.left = `${Math.random() * 100}%`;
            star.style.animationDelay = `${Math.random() * 5}s`; // Para que no parpadeen todas a la vez

            container.appendChild(star);
        }
    }

    // Llama a la función para crear 100 estrellas.
    createStars(100);


    // --- LÓGICA DEL RELOJ (SOLO PARA INDEX.HTML) ---

    // Obtiene el elemento span donde se mostrará la hora.
    const timeElement = document.getElementById('current-time');

    // Si el elemento del reloj no existe (ej. en 404.html), el resto del código no se ejecuta.
    if (timeElement) {
        /**
         * Función para actualizar la hora.
         */
        function updateTime() {
            // Crea un nuevo objeto Date para obtener la hora actual.
            const now = new Date();

            // Formatea la hora para mostrarla en un formato legible (ej: 20:05:30).
            const formattedTime = now.toLocaleTimeString('es-ES', {
                hour: '2-digit',
                minute: '2-digit',
                second: '2-digit',
                hour12: false // Formato de 24 horas
            });

            // Actualiza el contenido del elemento span con la hora formateada.
            timeElement.textContent = formattedTime;
        }

        // Llama a updateTime() una vez al cargar la página para mostrar la hora inmediatamente.
        updateTime();

        // Configura un intervalo para que la función updateTime() se ejecute cada 1000 milisegundos (1 segundo).
        // Esto mantiene la hora actualizada en tiempo real.
        setInterval(updateTime, 1000);
    }
});
