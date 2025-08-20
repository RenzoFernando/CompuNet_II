package org.example.repository;

import org.example.model.Student;
import java.util.ArrayList;

/**
 * La capa de Repositorio para los Estudiantes.
 */
public class StudentRepository {

    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Este método se utiliza para inicializar el repositorio con datos de prueba.
     * Spring lo llamará automáticamente después de crear el bean, gracias a la
     * configuración 'initMethod = "initRepo"' en la clase AppConfig.
     */
    public void initRepo(){
        students.add(new Student("1", "Luna", "101"));
        students.add(new Student("2", "Guz", "102"));
        students.add(new Student("3", "Renzo", "103"));
        System.out.println("StudentRepository inicializado con datos de ejemplo.");
    }
}
