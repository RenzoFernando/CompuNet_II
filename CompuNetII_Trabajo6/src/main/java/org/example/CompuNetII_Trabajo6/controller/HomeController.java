package org.example.CompuNetII_Trabajo6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador para manejar las peticiones a la página de inicio.
 * La anotación @Controller indica que esta clase es un controlador de Spring MVC.
 */
@Controller
public class HomeController {

    /**
     * Maneja las peticiones GET a la ruta raíz ("/").
     * Este método se ejecutará cuando un usuario visite la URL principal de la aplicación.
     *
     * @param model El objeto Model se utiliza para pasar datos desde el controlador a la vista (plantilla).
     * @return El nombre de la vista (plantilla HTML) que se debe renderizar. En este caso, "index".
     */
    @GetMapping("/")
    public String index(Model model) {
        // Agrega un atributo llamado "message" al modelo.
        // Este atributo podrá ser accedido desde la plantilla index.html usando Thymeleaf.
        model.addAttribute("message", "Welcome to CompuNetII Trabajo 6");

        // Retorna el nombre lógico de la vista. Spring Boot buscará un archivo llamado "index.html"
        // en el directorio de plantillas (generalmente src/main/resources/templates).
        return "index";
    }
}
