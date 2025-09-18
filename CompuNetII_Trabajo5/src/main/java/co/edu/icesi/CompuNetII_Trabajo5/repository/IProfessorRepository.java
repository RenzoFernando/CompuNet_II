package co.edu.icesi.CompuNetII_Trabajo5.repository;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Repositorio para la entidad Professor.
// Maneja la persistencia de objetos 'Professor', que tienen una clave primaria de tipo 'Integer'.
public interface IProfessorRepository extends JpaRepository<Professor, Integer> {
    // --- Ejer 2 ---
    List<Professor> findByNameContainingIgnoreCase(String name);

    // --- Ejer 10 ---
    List<Professor> findDistinctByCourses_StudentCourses_Student_Program(String program);

    // --- Semana 7 --- //
    Optional<Professor> findByCourses_Name(String courseName);

}
