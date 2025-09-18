package org.example.CompuNetII_Trabajo6.controller;

import org.example.CompuNetII_Trabajo6.entity.Student;
import org.example.CompuNetII_Trabajo6.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired; // Importar Autowired
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Controlador para gestionar las operaciones CRUD de los estudiantes.
 * @Controller indica que esta clase es un controlador de Spring MVC.
 * @RequestMapping("/students") mapea todas las peticiones que comiencen con "/students" a este controlador.
 */
@Controller
@RequestMapping("/students")
public class StudentsController {

    // @Autowired inyecta automáticamente una instancia de StudentService.
    // Spring se encarga de crear y gestionar el ciclo de vida de este objeto.
    @Autowired
    private StudentService studentService;

    /**
     * Maneja las peticiones GET a "/students".
     * Obtiene la lista de todos los estudiantes y la muestra en la vista.
     *
     * @param model El objeto Model para pasar datos a la vista.
     * @return El nombre de la vista a renderizar ("student/student-list").
     */
    @GetMapping
    public String getStudents(Model model) {
        // Llama al servicio para obtener todos los estudiantes de la base de datos.
        List<Student> studentList = studentService.findAll();
        // Agrega la lista de estudiantes al modelo con el nombre "studentList".
        model.addAttribute("studentList", studentList);

        // Crea un nuevo objeto Student vacío.
        // Este objeto se usará para el data-binding del formulario de creación de estudiantes.
        Student student = new Student();
        // Agrega el estudiante vacío al modelo con el nombre "student".
        model.addAttribute("student", student);

        // Retorna la ruta a la plantilla que mostrará la lista y el formulario.
        return "student/student-list";
    }

    /**
     * Maneja las peticiones POST a "/students/save".
     * Guarda un nuevo estudiante en la base de datos.
     *
     * @param student El objeto Student poblado con los datos del formulario gracias a @ModelAttribute.
     * @return Una cadena de redirección para volver a la lista de estudiantes.
     */
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        // Llama al servicio para guardar el objeto estudiante en la base de datos.
        studentService.save(student);
        // Redirige al usuario a la URL "/students". Esto hace que se ejecute el método getStudents()
        // de nuevo, mostrando la lista actualizada.
        return "redirect:/students";
    }
}
