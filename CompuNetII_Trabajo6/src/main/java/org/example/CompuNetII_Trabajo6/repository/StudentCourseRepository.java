package org.example.CompuNetII_Trabajo6.repository;

import org.example.CompuNetII_Trabajo6.entity.StudentCourse;
import org.example.CompuNetII_Trabajo6.entity.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseId> {
}
