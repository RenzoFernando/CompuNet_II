package org.example.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.AppContext;
import org.example.services.ShopService;

import java.io.IOException;

/**
 * Un Servlet es una clase Java que procesa peticiones HTTP (request) y genera respuestas (response).
 * En la arquitectura de 3 capas, este Servlet actúa como la capa de Controlador (Controller).
 * Su trabajo es recibir las acciones del usuario, interactuar con la capa de servicio y decidir qué vista mostrar.
 *
 * @WebServlet("/shop") mapea este servlet a la URL "/shop". Cualquier petición a http://.../shop será manejada por esta clase.
 */
@WebServlet("/shop")
public class ShopServlet extends HttpServlet {

    // Referencia a nuestra capa de servicio.
    private ShopService shopService;

    /**
     * El método init() es parte del ciclo de vida de un Servlet.
     * El contenedor de servlets (Tomcat) lo llama UNA SOLA VEZ cuando crea la instancia del servlet.
     * Es el lugar ideal para realizar inicializaciones costosas.
     *
     * Aquí, lo usamos para obtener nuestra instancia de ShopService del contenedor de Spring.
     * Esto es un ejemplo de 'Inyección de Dependencias' manual. En lugar de hacer 'new ShopService()',
     * le pedimos a Spring que nos dé la instancia que él gestiona.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        shopService = (ShopService) AppContext.getInstance().getBean("shopService");
    }

    /**
     * Maneja las peticiones HTTP GET.
     * Se ejecuta cuando un usuario navega directamente a la URL /shop en su navegador.
     * En este caso, solo muestra un mensaje simple.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Este es el servlet de la tienda. Accede desde el index.jsp</h1>");
    }

    /**
     * Maneja las peticiones HTTP POST.
     * Se ejecuta cuando el usuario envía el formulario desde index.jsp.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. Obtener los datos de la petición. El nombre 'compra' debe coincidir con el atributo 'name' del input en el HTML.
        String compra = req.getParameter("compra");

        // 2. Usar la capa de servicio para procesar la lógica de negocio.
        shopService.addItem(compra);

        // Imprime en la consola del servidor para depuración.
        System.out.println("Items en la lista: " + shopService.getItems().size());

        // 3. Redirigir al usuario de vuelta a la página principal para que vea la lista actualizada.
        // El './' se refiere a la raíz del contexto de la aplicación web.
        resp.sendRedirect("./");
    }
}
