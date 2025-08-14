// El evento 'DOMContentLoaded' se dispara cuando el documento HTML inicial ha sido
// completamente cargado y parseado, sin esperar a que las hojas de estilo, imágenes y subframes terminen de cargar.
document.addEventListener('DOMContentLoaded', function() {

    // Buscamos el campo de texto por su ID.
    const inputCompra = document.getElementById('compra-input');

    // Si el campo de texto existe, colocamos el cursor (foco) en él.
    // Esto mejora la experiencia de usuario, ya que puede empezar a escribir inmediatamente.
    if (inputCompra) {
        inputCompra.focus();
    }

    console.log("Página cargada y lista para la acción!");

});
