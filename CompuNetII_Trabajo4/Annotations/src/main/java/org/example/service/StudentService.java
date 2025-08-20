package org.example.service;

import org.example.model.Student;
import org.example.repository.CourseRepository;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * @Service es una especialización de @Component. Indica que esta clase
 * contiene la lógica de negocio. Spring la registrará como un bean.
 */
@Service
public class StudentService {

    // Las dependencias ahora son 'final' para asegurar que se inicialicen en el constructor.
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    /**
     * !!!CLAVE: Inyección de Dependencias por Constructor !!!
     * @Autowired en un constructor le dice a Spring que, para crear este bean (StudentService),
     * necesita encontrar otros beans (StudentRepository y CourseRepository) y pasarlos
     * como argumentos. Esta es la forma preferida de inyección porque asegura que el objeto
     * se crea en un estado válido y con todas sus dependencias listas.
     */
    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public void addStudent(Student student) {
        if(studentRepository.getStudents().contains(student)){
            System.out.println("El estudiante ya existe");
        } else {
            studentRepository.addStudent(student);
            System.out.println("Estudiante agregado: " + student.getName());
        }
    }

    public ArrayList<Student> getStudents() {
        return studentRepository.getStudents();
    }
}
