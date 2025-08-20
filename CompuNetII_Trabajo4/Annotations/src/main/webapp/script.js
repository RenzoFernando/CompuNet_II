// Se ejecuta cuando todo el contenido del DOM está cargado.
document.addEventListener('DOMContentLoaded', function() {

    // Seleccionamos los elementos del DOM con los que vamos a trabajar.
    const studentForm = document.querySelector('form');
    const studentIdInput = document.getElementById('studentId');
    const studentNameInput = document.getElementById('studentName');
    const courseIdInput = document.getElementById('courseId');
    const errorMessageDiv = document.getElementById('errorMessage');

    // Añadimos un 'escuchador' para el evento 'submit' del formulario.
    studentForm.addEventListener('submit', function(event) {
        // Limpiamos mensajes de error anteriores.
        errorMessageDiv.style.display = 'none';
        errorMessageDiv.textContent = '';

        // Creamos un array para guardar los mensajes de error.
        let errors = [];

        // --- INICIO DE LA VALIDACIÓN ---

        // 1. Validar que los campos no estén vacíos (quitando espacios en blanco).
        if (studentIdInput.value.trim() === '') {
            errors.push('El campo ID no puede estar vacío.');
        }
        if (studentNameInput.value.trim() === '') {
            errors.push('El campo Nombre no puede estar vacío.');
        }
        if (courseIdInput.value.trim() === '') {
            errors.push('El campo ID del Curso no puede estar vacío.');
        }

        // 2. Podrías añadir más validaciones aquí, por ejemplo:
        // if (studentIdInput.value.length < 5) {
        //     errors.push('El ID debe tener al menos 5 caracteres.');
        // }

        // --- FIN DE LA VALIDACIÓN ---

        // Si hay errores...
        if (errors.length > 0) {
            // Prevenimos que el formulario se envíe al servidor.
            event.preventDefault();

            // Mostramos el contenedor de errores y los listamos.
            errorMessageDiv.style.display = 'block';
            errorMessageDiv.innerHTML = errors.join('<br>'); // Usamos innerHTML para los saltos de línea.
        }
    });

    console.log("JavaScript cargado y listo para validar.");
});
