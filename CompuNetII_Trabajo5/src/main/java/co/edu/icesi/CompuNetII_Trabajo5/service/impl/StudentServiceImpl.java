package co.edu.icesi.CompuNetII_Trabajo5.service.impl;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Student;
import co.edu.icesi.CompuNetII_Trabajo5.repository.IProfessorRepository;
import co.edu.icesi.CompuNetII_Trabajo5.repository.IStudentRepository;
import co.edu.icesi.CompuNetII_Trabajo5.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service es una anotación de Spring que marca esta clase como un componente de servicio.
// Spring la detectará automáticamente y creará una instancia (un "bean") de esta clase
// que podrá ser inyectada en otros componentes, como los controladores.
// Por defecto, el nombre del bean será "studentServiceImpl" (el nombre de la clase con la primera letra en minúscula).
@Service
public class StudentServiceImpl implements IStudentService {

    // --- INYECCIÓN DE DEPENDENCIAS ---
    // @Autowired le pide a Spring que "inyecte" (proporcione) una instancia del StudentRepository aquí.
    // Esto conecta la capa de servicio con la capa de repositorio.
    // La capa de servicio USA el repositorio para acceder a los datos.
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private ProfessorServiceImpl professorServiceImpl;
    @Autowired
    private IProfessorRepository iProfessorRepository;

    // --- IMPLEMENTACIÓN DE LOS MÉTODOS DEL CONTRATO ---

    /**
     * Implementación real del método getCount.
     * Simplemente delega la llamada al método count() del repositorio.
     */
    @Override
    public long getCount() {
        return studentRepository.count();
    }

    /**
     * Implementación real del método getStudents.
     * Delega la llamada al método findAll() del repositorio para obtener todos los estudiantes.
     */
    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }


    // semana 7

    @Override
    public Optional<Student> findStudentByCode(String code) {
        Optional<Student> student = studentRepository.findByCode(code);
        if(student.isPresent()){
            return student;
        }else throw new RuntimeException("Student with code " + code + " not found");
    }

    @Override
    public List<Student> getStudentsByCourseName(String name) {
        if (iProfessorRepository.findByCourses_Name(name).isPresent()) {
            return studentRepository.findByStudentCourses_Course_Name(name);
        }
        throw new RuntimeException("Students with course name " + name + " not found");
    }

}
