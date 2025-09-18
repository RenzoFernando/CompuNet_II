package org.example.CompuNetII_Trabajo6.service;

import org.example.CompuNetII_Trabajo6.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();
    Optional<Course> findById(Integer id);
    Course save(Course course);
    void deleteById(Integer id);
}
