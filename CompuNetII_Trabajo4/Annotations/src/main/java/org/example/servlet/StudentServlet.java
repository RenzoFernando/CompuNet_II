package org.example.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.app.AppContext;
import org.example.model.Student;
import org.example.service.StudentService;

import java.io.IOException;

/**
 * Servlet para manejar las peticiones relacionadas con los Estudiantes.
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    // El servlet depende del servicio, no del repositorio directamente.
    private StudentService studentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        // Aquí se debería obtener el bean 'studentService'.
        // La línea actual obtiene el repositorio pero no lo asigna a ninguna variable de la clase.
        // Probablemente sea un paso intermedio en la construcción del código.
        // La forma correcta sería:
        // this.studentService = AppContext.getInstance().getBean("studentService", StudentService.class);
        this.studentService = AppContext.getInstance().getBean("studentService", StudentService.class);
    }

    /**
     * Maneja las peticiones POST, que típicamente vienen de un formulario HTML.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. parámetros del formulario (los 'name' del HTML)
        String id = req.getParameter("studentId");
        String name = req.getParameter("studentName");
        String courseId = req.getParameter("courseId");

        // 2. objeto Student con los datos del formulario
        Student newStudent = new Student(id, name, courseId);

        // 3. servicio para agregar el estudiante
        studentService.addStudent(newStudent);

        // 4. Redirigir al usuario a la página principal para ver los cambios
        resp.sendRedirect("./"); // El './' lleva al index.jsp
    }
}
