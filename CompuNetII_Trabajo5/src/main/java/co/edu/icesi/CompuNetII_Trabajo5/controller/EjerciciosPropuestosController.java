package co.edu.icesi.CompuNetII_Trabajo5.controller;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Course;
import co.edu.icesi.CompuNetII_Trabajo5.entity.Professor;
import co.edu.icesi.CompuNetII_Trabajo5.entity.Student;
import co.edu.icesi.CompuNetII_Trabajo5.repository.ICourseRepository;
import co.edu.icesi.CompuNetII_Trabajo5.repository.IProfessorRepository;
import co.edu.icesi.CompuNetII_Trabajo5.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@RestController
public class EjerciciosPropuestosController {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private IProfessorRepository professorRepository;

    @Autowired
    private ICourseRepository courseRepository;

    /*
        Ejercicios Propuestos
        Ahora es tu turno. Añade los siguientes métodos a los repositorios correspondientes y pruébalos.

        1. En StudentRepository
        Encuentra un estudiante por su código único.

        2. En ProfessorRepository
        Encuentra profesores cuyo nombre contenga una cadena de texto (ignorando mayúsculas y minúsculas).

        3. En CourseRepository
        Encuentra todos los cursos que tengan un número específico de créditos.

        4. En StudentRepository
        Encuentra todos los estudiantes de un programa académico.

        5. En CourseRepository
        Encuentra un curso por su nombre exacto, ignorando mayúsculas y minúsculas.

        6. En CourseRepository
        Encuentra todos los cursos impartidos por un profesor específico (por su nombre) y ordénalos alfabéticamente.

        7. En StudentRepository
        Encuentra todos los estudiantes de un programa específico cuyo código empiece por un prefijo determinado.

        8. En CourseRepository
        Encuentra todos los cursos cuyo número de créditos se encuentre en un rango (por ejemplo, entre 3 y 4 créditos).

        9. En StudentRepository
        Encuentra todos los estudiantes que están viendo cursos con un profesor específico (por el nombre del profesor). Esta consulta debe navegar Student → StudentCourse → Course → Professor.

        10. En ProfessorRepository: Encuentra todos los profesores (sin duplicados) que le enseñan a estudiantes de un programa académico específico. Esta es la más compleja, navegando Professor → Course → StudentCourse → Student.
     */

    @GetMapping("/ej1")
    public ResponseEntity<?> ej1(){
        Optional<Student> output = studentRepository.findByCode("2021102001");
        return ResponseEntity.status(200).body(output);
    }

    @GetMapping("/ej2")
    public ResponseEntity<?> ej2(){
        List<Professor> professors = professorRepository.findByNameContainingIgnoreCase("an");
        return ResponseEntity.status(200).body(professors);
    }

    @GetMapping("/ej3")
    public ResponseEntity<?> ej3() {
        List<Course> courses = courseRepository.findByCredits(3);
        return ResponseEntity.status(200).body(courses);
    }

    @GetMapping("/ej4")
    public ResponseEntity<?> ej4() {
        List<Student> students = studentRepository.findByProgram("Medicina");
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/ej5")
    public ResponseEntity<?> ej5() {
        Course course = courseRepository.findByNameIgnoreCase("derecho penal");
        return ResponseEntity.status(200).body(course);
    }

    @GetMapping("/ej6")
    public ResponseEntity<?> ej6() {
        List<Course> courses = courseRepository.findByProfessorNameOrderByNameAsc("Juan Perez");
        return ResponseEntity.status(200).body(courses);
    }

    @GetMapping("/ej7")
    public ResponseEntity<?> ej7() {
        List<Student> students = studentRepository.findByProgramAndCodeStartingWith("Ingenieria de Sistemas", "2021");
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/ej8")
    public ResponseEntity<?> ej8() {
        List<Course> courses = courseRepository.findByCreditsBetween(3, 4);
        return ResponseEntity.status(200).body(courses);
    }

    @GetMapping("/ej9")
    public ResponseEntity<?> ej9() {
        List<Student> students = studentRepository.findByStudentCourses_Course_Professor_Name("Juan Perez");
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/ej10")
    public ResponseEntity<?> ej10() {
        List<Professor> professors = professorRepository.findDistinctByCourses_StudentCourses_Student_Program("Derecho");
        return ResponseEntity.status(200).body(professors);
    }

    // Poner .status(200).body es lo mismo que poner .ok, pero es más explícito.
    // .ok(---) es un atajo para .status(200).body(---)


    //Semana 7

    @GetMapping("p1")
    public ResponseEntity<?> p1(){
        var output = courseRepository.findFirstByOrderByNameAsc();
        return ResponseEntity.status(200).body(output);
    }

    @GetMapping("p2")
    public ResponseEntity<?> p2(){
        var output = courseRepository.findTop2ByOrderByCreditsDesc();
        return ResponseEntity.status(200).body(output);
    }

    @GetMapping("p3")
    public ResponseEntity<?> p3(){
        var output = courseRepository.findFirst1ByProfessor_Name("Juan Perez");
        return ResponseEntity.status(200).body(output);
    }

    @GetMapping("p4")
    public ResponseEntity<?> p4(){
        var output = courseRepository.findByProfessor_NameOrderByNameDesc("Juan Perez");
        return ResponseEntity.status(200).body(output);
    }

    @GetMapping("p5")
    public ResponseEntity<?> p5(){
        var output = courseRepository.findByCreditsGreaterThanEqual(1, PageRequest.of(0, 4));
        return ResponseEntity.status(200).body(output);
    }
}

