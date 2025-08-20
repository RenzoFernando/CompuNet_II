package org.example.model;

/**
 * Clase de Modelo que representa a un Estudiante.
 */
public class Student {

    private String id;
    private String name;
    private String courseId;

    /**
     * Constructor por defecto.
     */
    public Student() {}

    /**
     * Constructor con parámetros.
     */
    public Student(String id, String name, String courseId) {
        this.id = id;
        this.name = name;
        this.courseId = courseId;
    }

    // --- Getters y Setters ---

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Sobrescribe el método equals() de la clase Object.
     * Esto es crucial para que métodos como 'ArrayList.contains()' funcionen correctamente.
     * Aquí, definimos que dos objetos Student son "iguales" si sus 'id' son iguales.
     */
    @Override
    public boolean equals(Object obj) {
        // Comprueba si el objeto a comparar es una instancia de Student.
        if(obj instanceof Student){
            // Si lo es, lo convierte (cast) a Student para poder acceder a sus métodos.
            Student other = (Student) obj;
            // Compara los 'id' de ambos estudiantes.
            return this.id.equals(other.id);
        } else {
            // Si no es un Student, no pueden ser iguales.
            return false;
        }
    }
}
