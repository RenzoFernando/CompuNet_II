package org.example.repository;

import org.example.model.Student;

import java.util.ArrayList;

/**
 * La capa de Repositorio para los Estudiantes.
 * Gestiona el acceso a los datos de los estudiantes.
 */
public class StudentRepository {

    // Simula una tabla de base de datos de estudiantes.
    private ArrayList<Student> students = new ArrayList<>();

    /**
     * Devuelve todos los estudiantes almacenados.
     * @return La lista de estudiantes.
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Añade un nuevo estudiante a la fuente de datos.
     * @param student El objeto Student a guardar.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Inicializa el repositorio con algunos datos de prueba.
     * Este método es un ejemplo de cómo podrías poblar el repositorio con datos inicial
     */
    public void initReo(){
        // Este método es un ejemplo de inicialización del repositorio.
        // Aquí podrías agregar estudiantes de prueba o realizar alguna configuración inicial.
        students.add(new Student("1", "Luna", "101"));
        students.add(new Student("2", "Guz", "102"));
        students.add(new Student("3", "Renzo", "103"));
        System.out.println("StudentRepository initialized with sample data.");
    }

}
