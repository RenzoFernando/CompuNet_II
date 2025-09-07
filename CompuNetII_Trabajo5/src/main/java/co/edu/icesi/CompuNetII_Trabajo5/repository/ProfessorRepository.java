package co.edu.icesi.CompuNetII_Trabajo5.repository;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repositorio para la entidad Professor.
// Maneja la persistencia de objetos 'Professor', que tienen una clave primaria de tipo 'Integer'.
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    // --- Ejer 2 ---
    List<Professor> findByNameContainingIgnoreCase(String name);

    // --- Ejer 10 ---
    List<Professor> findDistinctByCourses_StudentCourses_Student_Program(String program);

}
