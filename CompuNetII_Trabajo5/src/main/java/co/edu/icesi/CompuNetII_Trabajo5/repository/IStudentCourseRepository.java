package co.edu.icesi.CompuNetII_Trabajo5.repository;

import co.edu.icesi.CompuNetII_Trabajo5.entity.StudentCourse;
import co.edu.icesi.CompuNetII_Trabajo5.entity.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseId> {

}
