package org.example.service;

import org.example.repository.CourseRepository;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Marcamos esta clase como un @Service para que Spring la gestione.
 */
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    /**
     * Usamos la inyección por constructor, que es la práctica recomendada.
     * Spring buscará los beans de repositorios y los inyectará aquí al crear el CourseService.
     */
    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }
}
