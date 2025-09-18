package co.edu.icesi.CompuNetII_Trabajo5.unit.service;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Professor;
import co.edu.icesi.CompuNetII_Trabajo5.entity.Student;
import co.edu.icesi.CompuNetII_Trabajo5.repository.IProfessorRepository;
import co.edu.icesi.CompuNetII_Trabajo5.repository.IStudentRepository;
import co.edu.icesi.CompuNetII_Trabajo5.service.impl.StudentServiceImpl; // Importa la implementación
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks; // Importa InjectMocks
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    // Crea un mock para el repositorio, que es una dependencia.
    @Mock
    private IStudentRepository studentRepository;

    // Crea un mock para el otro repositorio que es dependencia.
    @Mock
    private IProfessorRepository iProfessorRepository;

    // Crea una instancia REAL de StudentServiceImpl e inyéctale los mocks de arriba.
    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void findStudentByCode_WhenStudentExist_ShouldReturnOptionalStudent(){
        // Arrange: Prepara el escenario.
        Student mockStudent = new Student();
        mockStudent.setCode("12345");
        // Cuando se llame a findByCode en el REPOSITORIO, devuelve el estudiante.
        when(studentRepository.findByCode("12345")).thenReturn(Optional.of(mockStudent));

        // Act: Ejecuta el método en el SERVICIO REAL.
        Optional<Student> student = studentService.findStudentByCode("12345");

        // Assert: Verifica el resultado.
        assertTrue(student.isPresent());
        assertEquals("12345", student.get().getCode());
    }

    @Test
    void findStudentByCode_WhenStudentDoesNotExist_ShouldThrowRuntimeException(){
        // Arrange: Cuando se llame a findByCode, devuelve un Optional vacío.
        when(studentRepository.findByCode("12345")).thenReturn(Optional.empty());

        // Act & Assert: Verifica que el SERVICIO REAL lance la excepción.
        assertThrows(RuntimeException.class, () -> {
            studentService.findStudentByCode("12345");
        });
    }

    @Test
    void getStudentsByCourseName_WhenCalled_ShouldReturnStudentList(){
        // Arrange
        // Simula que el profesor existe para el curso "Aplicadas"
        when(iProfessorRepository.findByCourses_Name("Aplicadas"))
                .thenReturn(Optional.of(new Professor()));
        // Simula que el repositorio de estudiantes devuelve una lista con dos estudiantes
        when(studentRepository.findByStudentCourses_Course_Name("Aplicadas"))
                .thenReturn(List.of(new Student(), new Student()));

        // Act: Llama al método del SERVICIO REAL
        List<Student> list = studentService.getStudentsByCourseName("Aplicadas");

        // Assert
        assertEquals(2, list.size());
    }
}