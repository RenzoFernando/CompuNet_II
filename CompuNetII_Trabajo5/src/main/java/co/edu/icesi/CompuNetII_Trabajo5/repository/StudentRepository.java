package co.edu.icesi.CompuNetII_Trabajo5.repository;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Repositorio para la entidad Student.
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // --- Ejer 1 ---
    Optional<Student> findByCode(String code);

    // --- Ejer 4 ---
    List<Student> findByProgram(String program);

    // --- Ejer 7 ---
    List<Student> findByProgramAndCodeStartingWith(String program, String prefix);

    // --- Ejer 9 ---
    List<Student> findByStudentCourses_Course_Professor_Name(String professorName);

}
