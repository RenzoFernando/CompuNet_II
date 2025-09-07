package co.edu.icesi.CompuNetII_Trabajo5.service.impl;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Student;
import co.edu.icesi.CompuNetII_Trabajo5.repository.StudentRepository;
import co.edu.icesi.CompuNetII_Trabajo5.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service es una anotación de Spring que marca esta clase como un componente de servicio.
// Spring la detectará automáticamente y creará una instancia (un "bean") de esta clase
// que podrá ser inyectada en otros componentes, como los controladores.
// Por defecto, el nombre del bean será "studentServiceImpl" (el nombre de la clase con la primera letra en minúscula).
@Service
public class StudentServiceImpl implements StudentService {

    // --- INYECCIÓN DE DEPENDENCIAS ---
    // @Autowired le pide a Spring que "inyecte" (proporcione) una instancia del StudentRepository aquí.
    // Esto conecta la capa de servicio con la capa de repositorio.
    // La capa de servicio USA el repositorio para acceder a los datos.
    @Autowired
    private StudentRepository studentRepository;

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
}
