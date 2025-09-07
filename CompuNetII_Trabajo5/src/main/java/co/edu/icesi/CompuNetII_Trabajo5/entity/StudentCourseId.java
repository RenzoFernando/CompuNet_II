package co.edu.icesi.CompuNetII_Trabajo5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

// @Embeddable indica que esta clase no es una entidad por sí misma, sino que sus campos
// pueden ser "embebidos" o incluidos dentro de otra entidad. En este caso, la usaremos
// como clave primaria compuesta para la entidad StudentCourse.
@Embeddable
public class StudentCourseId implements Serializable {
    // Es una buena práctica que las clases de ID compuesto implementen 'Serializable'.

    // @Column especifica el mapeo a la columna de la base de datos.
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "course_id")
    private Integer courseId;

    // --- Constructores, Getters y Setters ---
    public StudentCourseId() {
    }

    public StudentCourseId(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }


    // --- equals() y hashCode() ---
    // Es OBLIGATORIO sobreescribir los métodos equals() y hashCode() en una clase de ID compuesto.
    // JPA los necesita para comparar de manera eficiente si dos instancias de esta clave son iguales.
    // Dos IDs son iguales si tanto el studentId como el courseId son iguales.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // Comprobamos que el objeto 'o' sea una instancia de StudentCourseId.
        if(o instanceof StudentCourseId){
            StudentCourseId that = (StudentCourseId) o;
            // Comparamos los valores de los campos.
            return Objects.equals(studentId, that.studentId) && Objects.equals(courseId, that.courseId);
        } else return false;
    }

    @Override
    public int hashCode() {
        // Genera un código hash basado en los valores de ambos campos.
        return Objects.hash(studentId, courseId);
    }
}
