package co.edu.icesi.CompuNetII_Trabajo5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

// Marca esta clase como una entidad JPA que se mapeará a una tabla llamada 'students'.
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    private String program;

    // --- RELACIÓN UNO A MUCHOS (OneToMany) con la tabla intermedia StudentCourse ---
    // Un estudiante puede tener muchas inscripciones a cursos.
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    // 'mappedBy = "student"' indica que la entidad 'StudentCourse' gestiona la relación a través de su campo 'student'.
    // El valor "student" debe coincidir con el nombre del campo 'Student student' en la clase StudentCourse.

    // El funcionamiento de 'cascade' y 'orphanRemoval' es idéntico al explicado en la entidad Course.
    @JsonIgnore // Evita la recursión infinita al serializar a JSON.
    private List<StudentCourse> studentCourses;

    // StudentRepository


    // --- Constructores, Getters y Setters ---

    public Student() {
    }

    public Student(Integer id, String name, String code, String program) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.program = program;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
