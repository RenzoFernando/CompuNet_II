package co.edu.icesi.trabajo5.entity;

// Importa las anotaciones de Jakarta Persistence API (JPA), que es la
// especificación para la persistencia de datos en Java.
import jakarta.persistence.*;

// La anotación @Entity marca esta clase como una entidad de JPA,
// lo que significa que se mapeará a una tabla en la base de datos.
@Entity
// @Table especifica el nombre de la tabla en la base de datos. Si no se
// usa, Hibernate usará el nombre de la clase como nombre de la tabla.
@Table(name = "students")
public class Student {

    // @Id indica que este campo es la clave primaria de la tabla.
    @Id
    // @GeneratedValue especifica cómo se generará el valor del ID.
    // GenerationType.IDENTITY usa una columna de identidad de la base de datos
    // para generar valores automáticamente.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Estos campos representan las columnas de la tabla 'students'.
    private String name;
    private String code;
    private String program;

    // Un constructor vacío es necesario para que JPA pueda crear instancias
    // de la entidad.
    public Student() {}

    // Este es un constructor sobrecargado para facilitar la creación de objetos Student.
    public Student(int id, String name, String code, String program) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.program = program;
    }

    // Getters y setters


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