package org.example.service;

import org.example.repository.CourseRepository;
import org.example.repository.StudentRepository;

/**
 * Esta es la capa de Servicio (Service Layer) para los Cursos.
 * Orquesta las operaciones y contiene la lógica de negocio relacionada con los cursos.
 */
public class CourseService {

    // Dependencias hacia la capa de repositorio. El servicio NO accede a los datos directamente.
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    /**
     * Constructor utilizado por Spring para la Inyección de Dependencias.
     * Cuando Spring crea el bean 'courseService', le pasará las instancias de 'courseRepository'
     * y 'studentRepository' que también ha creado.
     * La clase no crea sus propias dependencias (new CourseRepository()), sino que las recibe.
     */
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }


}
