package org.example.CompuNetII_Trabajo6.repository;

import org.example.CompuNetII_Trabajo6.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByCode(String code);

    List<Student> findByStudentCourses_Course_Name(String name);

    List<Student> findAll();

}

