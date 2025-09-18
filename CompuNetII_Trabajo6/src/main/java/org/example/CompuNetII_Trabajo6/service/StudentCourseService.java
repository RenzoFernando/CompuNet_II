package org.example.CompuNetII_Trabajo6.service;

import org.example.CompuNetII_Trabajo6.entity.StudentCourse;
import org.example.CompuNetII_Trabajo6.entity.StudentCourseId;

import java.util.List;
import java.util.Optional;

public interface StudentCourseService {
    List<StudentCourse> findAll();
    Optional<StudentCourse> findById(StudentCourseId id);
    StudentCourse save(StudentCourse studentCourse);
    void deleteById(StudentCourseId id);
}
