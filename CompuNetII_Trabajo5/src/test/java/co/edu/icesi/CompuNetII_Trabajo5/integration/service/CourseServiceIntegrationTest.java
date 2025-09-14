package co.edu.icesi.CompuNetII_Trabajo5.integration.service;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Course;
import co.edu.icesi.CompuNetII_Trabajo5.entity.Professor;
import co.edu.icesi.CompuNetII_Trabajo5.repository.ICourseRepository;
import co.edu.icesi.CompuNetII_Trabajo5.repository.IProfessorRepository;
import co.edu.icesi.CompuNetII_Trabajo5.service.ICourseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CourseServiceIntegrationTest {

    @Autowired
    private ICourseService iCourseService;

    @Autowired
    private ICourseRepository iCourseRepository;

    @Autowired
    private IProfessorRepository IprofessorRepository;

    private Professor professor;

    //Las pruebas van aqui y se pueden nombrar como se quiera
    //Usar el decorador @Test
    //Cada prueba debe ser independiente
    //Usar aserciones para validar los resultados esperados
    //Ejemplo:

    //Prueba de ejemplo
    @BeforeEach
    void setup() {
        professor = new Professor();
        professor.setName("Alice Andrew");
        professor = IprofessorRepository.save(professor);
    }

    @AfterEach
    void cleanup() {
        iCourseRepository.deleteAll();
        IprofessorRepository.deleteAll();
    }




}
