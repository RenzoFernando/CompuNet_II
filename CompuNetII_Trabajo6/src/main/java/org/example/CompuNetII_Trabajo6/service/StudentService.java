package org.example.CompuNetII_Trabajo6.service;

import org.example.CompuNetII_Trabajo6.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    long getCount();

    List<Student> getStudents();

    Optional<Student> findStudentByCode(String code);

    List<Student> getStudentsByCourseName(String name);

    Optional<Student> findById(Integer id);

    Student save(Student student);

    void deleteById(Integer id);

    List<Student> findAll();
}
