package co.edu.icesi.trabajo5.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "profesor") // Un profesor puede tener muchos cursos
    private List<Course> courses;     //mappedBy indica el campo en la entidad Course que posee la relación

    //

    public Profesor() {}

    public Profesor(int id, String name, List<Course> courses) {
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
