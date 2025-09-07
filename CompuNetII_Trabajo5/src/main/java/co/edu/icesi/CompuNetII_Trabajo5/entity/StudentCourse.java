package co.edu.icesi.CompuNetII_Trabajo5.entity;

import jakarta.persistence.*;

// Esta es la entidad que representa la tabla intermedia 'students_courses' para la relación muchos-a-muchos.
// Cada instancia de esta clase representa una inscripción de un estudiante en un curso.
@Entity
@Table(name="students_courses")
public class StudentCourse {

    // @EmbeddedId le dice a JPA que la clave primaria de esta entidad no es un campo simple,
    // sino una clase aparte que hemos anotado con @Embeddable (la clase StudentCourseId).
    @EmbeddedId
    private StudentCourseId studentCourseId;


    // --- RELACIÓN MUCHOS A UNO (ManyToOne) con Course ---
    @ManyToOne(fetch = FetchType.LAZY)
    // 'fetch = FetchType.LAZY' es una optimización. Significa que cuando carguemos una entidad StudentCourse,
    // el objeto 'Course' asociado no se cargará de la base de datos inmediatamente. Solo se cargará
    // en el momento en que intentemos acceder a él (ej. 'miInscripcion.getCourse()'). Esto evita
    // cargar datos innecesarios y mejora el rendimiento.

    // @MapsId("courseId") es la clave para conectar la clave compuesta con la relación.
    // Le dice a JPA: "El campo 'courseId' de mi @EmbeddedId (StudentCourseId) es en realidad
    // la clave foránea que mapea a la entidad Course". El valor "courseId" DEBE COINCIDIR
    // con el nombre del atributo en la clase StudentCourseId.
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;


    // --- RELACIÓN MUCHOS A UNO (ManyToOne) con Student ---
    @ManyToOne(fetch = FetchType.LAZY)
    // El funcionamiento de @MapsId y @JoinColumn aquí es análogo al de la relación con Course.
    // Le decimos a JPA que el campo 'studentId' de nuestra clave compuesta mapea a la entidad Student.
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;


    // --- Constructores, Getters y Setters ---

    public StudentCourse() {
    }

    public StudentCourseId getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(StudentCourseId studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
