package co.edu.icesi.trabajo5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne                        // Muchos cursos pueden tener un mismo profesor
    @JoinColumn(name = "profesor_id") // Nombre de la columna en la tabla
    private Profesor profesor;        // Esto es solo una instancia

    //

    public Course() {}

    public Course(int id, String name, Profesor profesor) {
        this.id = id;
        this.name = name;
    }

    //


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
