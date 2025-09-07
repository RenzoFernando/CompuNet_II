package co.edu.icesi.CompuNetII_Trabajo5.repository;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Esta interfaz se encarga de todas las operaciones de base de datos para la entidad Course.
// Extiende JpaRepository, indicando que manejará entidades 'Course' cuya clave primaria es de tipo 'Integer'.
public interface CourseRepository extends JpaRepository<Course, Integer> {
    // Por ahora, esta interfaz está vacía porque los métodos heredados de JpaRepository

    // --- Ejer 3 ---
    List<Course> findByCredits(int credits);

    // --- Ejer 5 ---
    Course findByNameIgnoreCase(String name);

    // --- Ejer 6 ---
    List<Course> findByProfessorNameOrderByNameAsc(String professorName);

    // --- Ejer 8 ---
    List<Course> findByCreditsBetween(int startCredits, int endCredits);
}
