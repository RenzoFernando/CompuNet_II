package co.edu.icesi.trabajo5.repository;
import co.edu.icesi.trabajo5.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Integer> {
//Al poner @Repository ya se creo un been de este repositorio, o sea studentRepository


}
