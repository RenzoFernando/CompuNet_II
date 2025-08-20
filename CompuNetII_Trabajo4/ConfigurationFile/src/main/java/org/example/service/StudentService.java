package org.example.service;

import org.example.model.Student;
import org.example.repository.CourseRepository;
import org.example.repository.StudentRepository;
import java.util.ArrayList;

/**
 * La capa de Servicio para los Estudiantes. Su lógica no cambia,
 * pero ahora sus dependencias son inyectadas por la configuración de AppConfig.
 */
public class StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    /**
     * Constructor para la Inyección de Dependencias. Spring usará este constructor
     * para pasarle las instancias de los repositorios que creó en AppConfig.
     */
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    /**
     * Añade un estudiante, aplicando la regla de negocio de no permitir duplicados.
     */
    public void addStudent(Student student) {
        if(studentRepository.getStudents().contains(student)){
            System.out.println("El estudiante ya existe");
        } else {
            studentRepository.addStudent(student);
            // Asumiendo que la clase Student fue corregida para tener getName()
            System.out.println("Estudiante agregado: " + student.getName());
        }
    }

    /**
     * Devuelve una lista de estudiantes. En una implementación futura,
     * podría filtrar por el ID del curso.
     */
    public ArrayList<Student> getStudentsByCourse(String courseId) {
        // TODO: Implementar la lógica de filtrado por courseId.
        return studentRepository.getStudents();
    }

    /**
     * Devuelve la lista completa de estudiantes.
     */
    public ArrayList<Student> getStudents() {
        return studentRepository.getStudents();
    }
}
