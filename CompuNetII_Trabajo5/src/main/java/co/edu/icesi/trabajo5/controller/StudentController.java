package co.edu.icesi.trabajo5.controller;

import co.edu.icesi.trabajo5.entity.Student;
import co.edu.icesi.trabajo5.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("count")
    public String getStudentCount() {
        long count = studentRepository.count();
        return "Estudiantes: " +  count;
    }

    @GetMapping("students")
    public String getStudents() {
        String result = "";
        for (Student student : studentRepository.findAll()) {
            result += student.getName() + "\n";
        }
        return result.toString();
    }
}
