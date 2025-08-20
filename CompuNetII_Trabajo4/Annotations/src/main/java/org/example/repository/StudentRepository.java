package org.example.repository;

import jakarta.annotation.PostConstruct; // Importación necesaria
import org.example.model.Student;
import org.springframework.stereotype.Repository; // Importación necesaria
import java.util.ArrayList;

/**
 * @Repository es una especialización de @Component. Le indica a Spring que esta clase
 * es un "Repositorio", es decir, una clase de acceso a datos. Spring la registrará como un bean.
 */
@Repository
public class StudentRepository {

    /**
     * Lista que almacena los estudiantes.
     */
    private ArrayList<Student> students = new ArrayList<>();

    /**
     * Método para obtener la lista de estudiantes.
     * @return Lista de estudiantes.
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Método para agregar un estudiante al repositorio.
     * @param student El estudiante a agregar.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * @PostConstruct es una anotación que le dice a Spring: "después de que hayas construido
     * este objeto y realizado todas las inyecciones, ejecuta este método".
     * Es el equivalente en anotaciones al 'init-method' del XML.
     */
    @PostConstruct
    public void initRepo(){
        students.add(new Student("1", "Luna", "101"));
        students.add(new Student("2", "Guz", "102"));
        students.add(new Student("3", "Renzo", "103"));
        System.out.println("StudentRepository inicializado con datos de ejemplo vía @PostConstruct.");
    }
}
