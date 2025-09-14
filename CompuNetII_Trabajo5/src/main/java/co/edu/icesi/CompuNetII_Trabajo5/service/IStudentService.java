package co.edu.icesi.CompuNetII_Trabajo5.service;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Student;

import java.util.List;
import java.util.Optional;

// --- INTERFAZ DE SERVICIO ---
// Una interfaz en la capa de servicio define un "contrato".
// Establece QUÉ operaciones de negocio se pueden realizar relacionadas con los estudiantes,
// pero no dice CÓMO se hacen. Esto es fundamental para el desacoplamiento.
// El controlador dependerá de esta interfaz, no de una implementación concreta.
public interface IStudentService {

    /**
     * Define la operación para contar el número total de estudiantes.
     * @return el número total de estudiantes.
     */
    long getCount();

    /**
     * Define la operación para obtener una lista de todos los estudiantes.
     * @return una lista con todas las entidades Student.
     */
    List<Student> getStudents();

    //semana 7
    Optional<Student> findStudentByCode(String code);

    List<Student> getStudentsByCourseName(String name);
}
