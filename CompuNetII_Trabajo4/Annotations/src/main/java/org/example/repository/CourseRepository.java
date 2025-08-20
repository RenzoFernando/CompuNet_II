package org.example.repository;

import org.example.model.Course;

import java.util.ArrayList;

/**
 * Esta es la capa de Repositorio (Repository Layer) para los Cursos.
 * Su única responsabilidad es interactuar con la fuente de datos.
 * En este ejemplo, la "fuente de datos" es una simple lista en memoria (ArrayList).
 * En una aplicación real, aquí estaría el código para conectar y consultar una base de datos (JDBC, JPA, etc.).
 */
public class CourseRepository {
    // Simula una tabla de base de datos de cursos.
    private ArrayList<Course> courses = new ArrayList<>();

    /**
     * Devuelve todos los cursos almacenados.
     * @return La lista de cursos.
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Añade un nuevo curso a la fuente de datos.
     * @param course El objeto Course a guardar.
     */
    public void addCourse(Course course) {
        courses.add(course);
    }
}
