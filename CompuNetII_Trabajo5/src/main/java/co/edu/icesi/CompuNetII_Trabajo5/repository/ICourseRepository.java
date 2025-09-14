package co.edu.icesi.CompuNetII_Trabajo5.repository;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Esta interfaz se encarga de todas las operaciones de base de datos para la entidad Course.
// Extiende JpaRepository, indicando que manejará entidades 'Course' cuya clave primaria es de tipo 'Integer'.
public interface ICourseRepository extends JpaRepository<Course, Integer> {
    // Por ahora, esta interfaz está vacía porque los métodos heredados de JpaRepository

    // --- Ejer 3 ---
    List<Course> findByCredits(int credits);

    // --- Ejer 5 ---
    Course findByNameIgnoreCase(String name);

    // --- Ejer 6 ---
    List<Course> findByProfessorNameOrderByNameAsc(String professorName);

    // --- Ejer 8 ---
    // Lo comento porque lo implementé en la semana 7 otra vez
    //List<Course> findByCreditsBetween(int startCredits, int endCredits);

    // SEMANA 7

    // Obtiene los primeros 100 cursos de un profesor específico
    List<Course> findFirst100ByProfessor_Name(String professorName);

    // Obtiene el primer curso que encuentra ordenado por nombre ascendente
    Optional<Course> findFirstByOrderByNameAsc();

    // Obtiene los 2 cursos con más créditos
    List<Course> findTop2ByOrderByCreditsDesc();

    // Obtiene los 3 cursos del profesor "Juan Perez"
    // EL gion bajo ( _ ) nos ayuda a que se acceda a los datos de la otra tabla es decir en
    // este caso al "name" de la tabla "Professors"
    List<Course> findFirst1ByProfessor_Name(String professor);

    // En CourseRepository
    // Encuentra cursos cuyos créditos estén entre 3 y 4
    List<Course> findByCreditsBetween(int minCredits, int maxCredits);

    // Encuentra todos los cursos de un profesor, ordenados por nombre del curso de forma descendente
    List<Course> findByProfessor_NameOrderByNameDesc(String professorName);

    // Encuentra todos los cursos con 4 créditos, ordenados por nombre ascendente
    List<Course> findByCreditsOrderByNameAsc(int credits);

    // Encuentra todos los cursos de un programa y devuelve los resultados paginados
    Page<Course> findByProfessor_Name(String professorName, Pageable pageable);

    // Encuentra todos los cursos con créditos mayores o iguales a un valor dado, con paginación
    Page<Course> findByCreditsGreaterThanEqual(int credits, Pageable pageable);

    //¿Cómo se hacen estas queries en JAP?
    //Se hacen de tal forma segun la documentacion de este mismo
    //https://docs.spring.io/spring-data/jpa/reference/jpa.html

    // --- ¿Cómo funciona JPA en este proyecto? ---
    //
    // Este proyecto utiliza Spring Data JPA, que se basa en la especificación
    // JPA (Java Persistence API) para gestionar la comunicación con la base de datos.
    // El flujo de trabajo es el siguiente:
    //
    // 1. @Entity: Nuestras clases de modelo (como Course, Professor) están anotadas
    //    con @Entity. Esto le dice a JPA que cada clase representa una tabla en la
    //    base de datos y cada objeto, una fila. Este concepto se llama ORM
    //    (Object-Relational Mapping).
    //
    // 2. JpaRepository: Nuestras interfaces de repositorio (como ICourseRepository)
    //    extienden JpaRepository. Esto nos da métodos CRUD (save, findById, delete, etc.)
    //    y la capacidad de crear nuestras propias consultas a través de los nombres de
    //    los métodos (Query Methods).
    //
    // 3. EntityManager: En segundo plano, Spring Data JPA utiliza el EntityManager
    //    de JPA. Este es el componente central que gestiona el ciclo de vida de las
    //    entidades (guardar, actualizar, eliminar) y las mantiene sincronizadas con
    //    la base de datos a través de un "Contexto de Persistencia".
    //
    // 4. Hibernate: Es el "proveedor de JPA" que usamos por defecto. Es el motor que
    //    implementa la especificación JPA, traduciendo las operaciones de objetos
    //    y las consultas JPQL a SQL nativo que la base de datos entiende.
    //
    // En resumen:
    // [Código] -> [Repositorio Spring] -> [EntityManager JPA] -> [Hibernate] -> [Base de Datos]


}
