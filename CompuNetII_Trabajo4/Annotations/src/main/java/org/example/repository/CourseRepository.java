package org.example.repository;

import org.example.model.Course;
import org.springframework.stereotype.Repository; // Importación necesaria
import java.util.ArrayList;

/**
 * Marcamos esta clase con @Repository para que el Component Scan de Spring
 * la detecte y la registre como un bean en el contenedor.
 */
@Repository
public class CourseRepository {

    /**
     * Lista que almacena los cursos.
     */
    private ArrayList<Course> courses = new ArrayList<>();

    /**
     * Método para obtener la lista de cursos.
     * @return Lista de cursos.
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Método para agregar un curso al repositorio.
     * @param course El curso a agregar.
     */
    public void addCourse(Course course) {
        courses.add(course);
    }
}
