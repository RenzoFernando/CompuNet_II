package co.edu.icesi.CompuNetII_Trabajo5.unit.service;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Student;
import co.edu.icesi.CompuNetII_Trabajo5.repository.IStudentRepository;
import co.edu.icesi.CompuNetII_Trabajo5.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentRepository studentRepository;

    @Mock
    private IStudentService studentService;

    @Test
    void findStudentByCode_WhenStudentExist_ShouldReturnOptionalStudent(){

        Student mockStudent = new Student();

        when(studentRepository.findByCode("12345")).thenReturn(Optional.of(mockStudent));

        Optional<Student> student = studentService.findStudentByCode("12345");
        assertTrue(student.isPresent());
    }
}
