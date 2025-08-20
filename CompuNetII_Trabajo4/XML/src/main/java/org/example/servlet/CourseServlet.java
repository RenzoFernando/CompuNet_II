package org.example.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

/**
 * Servlet para manejar las peticiones relacionadas con los Cursos.
 * Actúa como el Controlador en la arquitectura.
 */
@WebServlet("/course")
public class CourseServlet extends HttpServlet {

    /**
     * El método init() se llama una sola vez cuando el servlet es inicializado por el servidor.
     * Aquí es donde se obtendrían las dependencias (como el CourseService) del contexto de Spring.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // El código para obtener el 'courseService' del AppContext iría aquí.
        System.out.println("CourseServlet initialized");
    }

}
