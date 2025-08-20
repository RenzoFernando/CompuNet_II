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

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentService studentService;

    /**
     * El método init se ejecuta una vez al iniciar el servlet.
     * Aquí obtenemos la instancia del 'studentService' del contenedor de Spring,
     * que ahora está configurado a través de la clase AppConfig.
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        studentService = AppContext.getInstance().getBean("studentService", StudentService.class);
    }

    /**
     * Maneja las peticiones POST del formulario para crear un nuevo estudiante.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. Leer los parámetros del formulario.
        String id = req.getParameter("studentId");
        String name = req.getParameter("studentName");
        String courseId = req.getParameter("courseId");

        // 2. Crear el objeto Student.
        Student newStudent = new Student(id, name, courseId);

        // 3. Usar el servicio para aplicar la lógica de negocio.
        studentService.addStudent(newStudent);

        // 4. Redirigir al usuario a la página principal.
        resp.sendRedirect("./");
    }
}
