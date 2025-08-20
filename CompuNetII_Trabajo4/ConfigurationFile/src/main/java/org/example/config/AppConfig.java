package org.example.config;

import org.example.repository.CourseRepository;
import org.example.repository.StudentRepository;
import org.example.service.CourseService;
import org.example.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Esta es la clase de configuración principal de Spring.
 * Reemplaza por completo la necesidad de tener un archivo context.xml.
 * @Configuration le dice a Spring que esta clase contiene definiciones de beans.
 */
@Configuration
public class AppConfig {

    /**
     * La anotación @Bean le indica a Spring que el objeto devuelto por este método
     * debe ser registrado como un bean en el contenedor de Spring.
     * El nombre del método ("studentRepository") se convierte por defecto en el ID del bean.
     *
     * 'initMethod = "initRepo"' le dice a Spring que, después de crear la instancia
     * de StudentRepository, debe llamar al método llamado "initRepo".
     * Esto es útil para poblar datos iniciales o realizar configuraciones.
     */
    @Bean(initMethod = "initRepo")
    public StudentRepository studentRepository() {
        return new StudentRepository();
    }

    @Bean
    public CourseRepository courseRepository() {
        return new CourseRepository();
    }

    /**
     * Este método también define un bean. Fíjate en los parámetros del método.
     * Spring ve que este método necesita un StudentRepository y un CourseRepository.
     * Automáticamente buscará los beans que correspondan a esos tipos (los que definimos arriba)
     * y los pasará como argumentos. Esto es la Inyección de Dependencias.
     */
    @Bean
    public StudentService studentService(
            StudentRepository studentRepository,
            CourseRepository courseRepository
    ) {
        // Creamos la instancia del servicio pasándole las dependencias que Spring nos proveyó.
        return new StudentService(studentRepository, courseRepository);
    }

    @Bean
    public CourseService  courseService(
            CourseRepository courseRepository,
            StudentRepository studentRepository
    ) {
        return new CourseService(courseRepository, studentRepository);
    }
}
