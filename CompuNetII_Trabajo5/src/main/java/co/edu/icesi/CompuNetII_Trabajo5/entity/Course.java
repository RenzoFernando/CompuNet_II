package co.edu.icesi.CompuNetII_Trabajo5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

// Marca esta clase como una entidad JPA que se mapeará a una tabla llamada 'courses'.
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int credits;

    // --- RELACIÓN MUCHOS A UNO (ManyToOne) con Professor ---
    // Muchos cursos pueden ser impartidos por un solo profesor.
    @ManyToOne
    // @JoinColumn especifica la columna de clave foránea (foreign key) en la tabla 'courses'.
    // Esta columna ('professorId') contendrá el ID del profesor que imparte el curso.
    // Esta entidad (Course) es la "dueña" de la relación, por eso tiene la JoinColumn.
    @JoinColumn(name = "professor_id")
    private Professor professor;


    // --- RELACIÓN UNO A MUCHOS (OneToMany) con la tabla intermedia StudentCourse ---
    // Un curso puede tener muchas inscripciones (registros en la tabla intermedia).
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    // 'mappedBy = "course"' indica que la entidad 'StudentCourse' gestiona esta relación a través de su campo 'course'.
    // El valor "course" debe coincidir con el nombre del campo 'Course course' en la clase StudentCourse.

    // 'cascade = CascadeType.ALL': Propaga todas las operaciones (guardar, actualizar, eliminar) desde Course
    // a sus StudentCourse asociados. Si eliminas un curso, se eliminarán todas sus inscripciones en la tabla intermedia.

    // 'orphanRemoval = true': Si quitas una inscripción de la lista 'studentCourses' de un curso y guardas el curso,
    // esa inscripción "huérfana" se eliminará automáticamente de la base de datos. Es útil para mantener la consistencia.
    @JsonIgnore // Para evitar recursión infinita al serializar a JSON.
    private List<StudentCourse> studentCourses;

    // --- Constructores, Getters y Setters ---

    public Course() {
    }

    public Course(Integer id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
