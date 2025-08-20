package org.example.model;

/**
 * Esta es una clase de Modelo, también conocida como POJO (Plain Old Java Object) o Entidad.
 * Su único propósito es representar y contener datos, en este caso, la información de un curso.
 * No contiene lógica de negocio.
 */
public class Course {

    // Atributos que definen un curso.
    private String id;
    private String name;
    private String profesorName;

    /**
     * Constructor por defecto. Es necesario para que algunos frameworks, como Spring,
     * puedan instanciar la clase fácilmente.
     */
    public Course() {

    }

    /**
     * Constructor con parámetros para crear un objeto Course con todos sus datos iniciales.
     */
    public Course(String id, String name, String profesorName) {
        this.id = id;
        this.name = name;
        this.profesorName = profesorName;
    }

    // --- Getters y Setters ---
    // Métodos públicos para acceder y modificar los atributos privados de la clase (Encapsulamiento).

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

    public String getProfesorName() {
        return profesorName;
    }

    public void setProfesorName(String profesorName) {
        this.profesorName = profesorName;
    }


}
