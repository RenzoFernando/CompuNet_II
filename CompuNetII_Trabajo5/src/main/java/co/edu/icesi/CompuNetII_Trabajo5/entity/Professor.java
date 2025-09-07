package co.edu.icesi.CompuNetII_Trabajo5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

// Marca esta clase como una entidad JPA que se mapeará a una tabla llamada 'professors'.
@Entity
@Table(name = "professors")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    // --- RELACIÓN UNO A MUCHOS (OneToMany) con Course ---
    // Un profesor puede impartir muchos cursos.
    @OneToMany(mappedBy = "professor")
    // 'mappedBy = "professor"' es CRUCIAL. Indica que la entidad 'Course' es la "dueña" de esta relación.
    // Esto significa que en la tabla 'courses' habrá una columna (foreign key) que apunta al profesor,
    // pero en la tabla 'professors' no habrá ninguna columna relacionada con los cursos.
    // El valor "professor" debe coincidir EXACTAMENTE con el nombre del campo 'Professor professor' en la clase Course.

    // @JsonIgnore es muy importante para evitar problemas de "recursión infinita" al convertir el objeto a JSON.
    // Si no lo pusiéramos, al pedir un profesor, Jackson intentaría mostrar sus cursos.
    // Y por cada curso, intentaría mostrar su profesor, que a su vez tiene cursos, y así infinitamente.
    @JsonIgnore
    private List<Course> courses;

    // --- Constructores, Getters y Setters ---

    public Professor() {
    }

    public Professor(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
