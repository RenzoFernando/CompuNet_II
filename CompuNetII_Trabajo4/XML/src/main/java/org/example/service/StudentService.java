package org.example.service;

import org.example.model.Student;
import org.example.repository.CourseRepository;
import org.example.repository.StudentRepository;
import java.util.ArrayList;

/**
 * La capa de Servicio para los Estudiantes.
 */
public class StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository; // Dependencia directa al repositorio de cursos.

    /**
     * CORRECCIÓN LÓGICA:
     * El constructor ahora recibe los dos repositorios que este servicio necesita para operar,
     * en lugar de depender de otro servicio (CourseService). Esto hace que la clase sea más cohesiva.
     */
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    /**
     * Añade un estudiante, aplicando la regla de negocio para evitar duplicados.
     * @param student El estudiante a añadir.
     */
    public void addStudent(Student student) {
        if(studentRepository.getStudents().contains(student)){
            System.out.println("El estudiante ya existe");
        } else {
            studentRepository.addStudent(student);
            // Se asume que la clase Student tiene un método getName()
            System.out.println("Estudiante agregado: " + student.getName());
        }
    }

    /**
     * Obtiene una lista de estudiantes. En una futura implementación,
     * podría usar el 'courseRepository' para filtrar los estudiantes por el ID del curso.
     * @param courseId El ID del curso por el cual filtrar.
     * @return Una lista de estudiantes.
     */
    public ArrayList<Student> getStudentsByCourse(String courseId) {
        // TODO: Implementar la lógica para filtrar estudiantes usando el courseId.
        return studentRepository.getStudents();
    }

    /**
     * Devuelve la lista completa de todos los estudiantes.
     * @return una lista de todos los estudiantes.
     */
    public ArrayList<Student> getStudents() {
        return studentRepository.getStudents();
    }
}
