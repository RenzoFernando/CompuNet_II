package org.example.CompuNetII_Trabajo6.service.impl;

import org.example.CompuNetII_Trabajo6.entity.StudentCourse;
import org.example.CompuNetII_Trabajo6.entity.StudentCourseId;
import org.example.CompuNetII_Trabajo6.repository.StudentCourseRepository;
import org.example.CompuNetII_Trabajo6.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Override
    public List<StudentCourse> findAll() {
        return studentCourseRepository.findAll();
    }

    @Override
    public Optional<StudentCourse> findById(StudentCourseId id) {
        return studentCourseRepository.findById(id);
    }

    @Override
    public StudentCourse save(StudentCourse studentCourse) {
        return studentCourseRepository.save(studentCourse);
    }

    @Override
    public void deleteById(StudentCourseId id) {
        studentCourseRepository.deleteById(id);
    }
}
