package org.example.servlet;

import jakarta.servlet.annotation.WebServlet; // La usamos para la anotación @WebServlet.
import jakarta.servlet.http.HttpServlet;       // La clase base para cualquier servlet que maneje HTTP.
import jakarta.servlet.http.HttpServletRequest; // Representa la petición que llega del navegador del cliente.
import jakarta.servlet.http.HttpServletResponse;// Representa la respuesta que le enviaremos al cliente.
import java.io.IOException;                     // Para manejar posibles errores de entrada/salida al escribir la respuesta.

// --- NOTA DE ANOTACIÓN @WebServlet ---
// Esta es la forma moderna (desde Servlet 3.0) de registrar un servlet.
// Le dice al servidor Tomcat: "Cualquier petición HTTP que llegue a la URL '/hello',
// envíamela a esta clase para que la procese".
// Antes, esto se hacía en un archivo de configuración XML llamado 'web.xml'. Esto es mucho más fácil.
@WebServlet("/hello")
public class ServletExample extends HttpServlet { // Nuestra clase HEREDA de HttpServlet, convirtiéndose en un servlet.

    // --- NOTA DEL MÉTODO doGet ---
    // La anotación @Override indica que estamos sobreescribiendo un método de la clase padre (HttpServlet).
    // El método 'doGet' se ejecuta específicamente cuando la petición del cliente es de tipo HTTP GET.
    // (Ej: cuando escribes una URL en el navegador y presionas Enter).
    //
    // Parámetros:
    // - HttpServletRequest req: Un objeto que contiene toda la información de la petición del cliente
    //   (URLs, encabezados, parámetros, etc.).
    // - HttpServletResponse resp: Un objeto que usaremos para construir y enviar nuestra respuesta de vuelta
    //   al cliente.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 1. Establecer el tipo de contenido de la respuesta.
        // Le decimos al navegador: "Lo que te estoy enviando es un documento HTML".
        // Esto es un encabezado HTTP: Content-Type: text/html
        resp.setContentType("text/html");

        // 2. Obtener el "escritor" de la respuesta para poder enviarle texto.
        // resp.getWriter() nos da un objeto PrintWriter con el que podemos escribir el cuerpo de la respuesta.
        // Y luego, con .println(), escribimos una línea de texto (en este caso, código HTML).
        resp.getWriter().println("<h1>Este es un servlet de Renzo<h1>");
    }
}