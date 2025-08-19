package org.example.service;

import org.example.model.Student;
import org.example.repository.StudentRepository;

import java.util.ArrayList;

/**
 * La capa de Servicio para los Estudiantes.
 */
public class StudentService {

    // Dependencias hacia el repositorio de estudiantes y el servicio de cursos.
    private StudentRepository studentRepository;
    private CourseService courseService; // Un servicio puede depender de otro servicio.

    /**
     * Constructor para la Inyección de Dependencias de Spring.
     */
    public StudentService(StudentRepository studentRepository, CourseService courseService) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
    }


    /**
     * Añade un estudiante, aplicando una regla de negocio.
     * @param student El estudiante a añadir.
     */
    public void addStudent(Student student) {
        // --- INICIO DE LA LÓGICA DE NEGOCIO ---
        // Regla: no se permiten estudiantes duplicados.
        // Gracias al método equals() que sobrescribimos en la clase Student,
        // .contains() buscará un estudiante con el mismo ID.
        if(studentRepository.getStudents().contains(student)){
            System.out.println("El estudiante ya existe");
        } else {
            // Si no existe, delega la acción de guardado a la capa de repositorio.
            studentRepository.addStudent(student);
            System.out.println("Estudiante agregado: " + student.getName());
        }
    }

    /**
     * Obtiene una lista de estudiantes filtrada por curso.
     * Este método es un ejemplo de cómo un servicio puede interactuar con otro servicio.
     * En una aplicación real, aquí podrías aplicar más lógica de negocio.
     * @param courseId
     * @return
     */
    public ArrayList<Student> getStudentsByCourse(String courseId) {
        return studentRepository.getStudents();
    }

    /**
     * El servicio le pide los datos al repositorio y los devuelve.
     * Así, el JSP no necesita saber nada sobre el repositorio.
     * @return una lista de todos los estudiantes.
     */
    public ArrayList<Student> getStudents() {
        return studentRepository.getStudents();
    }


}
