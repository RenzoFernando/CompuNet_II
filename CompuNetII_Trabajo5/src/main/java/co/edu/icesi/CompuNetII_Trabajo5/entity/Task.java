package co.edu.icesi.CompuNetII_Trabajo5.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Define la entidad `Task`, que se corresponde con la tabla `tasks` en la base de datos.
 * Esta clase es gestionada por JPA para las operaciones de persistencia.
 */
@Entity // Indica que esta clase es una entidad gestionada por JPA.
@Table(name = "tasks") // Especifica el nombre de la tabla de la base de datos a la que se mapea esta entidad.
public class Task {

    /**
     * Identificador único y clave primaria de la entidad Task.
     */
    @Id // Designa este campo como la clave primaria de la tabla.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Configura la estrategia de generación para la clave primaria.
    // GenerationType.IDENTITY indica que la generación del valor se delega
    // a una columna de identidad en la base de datos (ej. AUTO_INCREMENT).
    private Long id;

    /**
     * Código de negocio único que identifica la tarea.
     */
    @Column(name = "task_code", unique = true, nullable = false)
    // Mapea la propiedad a la columna 'task_code'.
    // unique = true: Aplica una restricción de unicidad a la columna.
    // nullable = false: La columna no puede contener valores nulos.
    private String taskCode;

    /**
     * Fecha y hora de ejecución programada para la tarea.
     * Se mapea a un tipo de dato SQL TIMESTAMP o equivalente.
     */
    @Column(name = "execution_time")
    private LocalDateTime executionTime;

    /**
     * Fecha de creación de la tarea.
     * Se mapea a un tipo de dato SQL DATE.
     */
    @Column(name = "creation_date")
    private LocalDate creationDate;

    /**
     * Descripción detallada de la tarea.
     */
    @Column(nullable = true, length = 500)
    // Mapea la propiedad a la columna 'description'.
    // nullable = true: Permite que la columna contenga valores nulos.
    // length = 500: Establece la longitud máxima de la columna (ej. VARCHAR(500)).
    private String description;

    // --- Métodos de Acceso y Modificación ---
    // Getters y Setters para las propiedades de la entidad.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(LocalDateTime executionTime) {
        this.executionTime = executionTime;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

