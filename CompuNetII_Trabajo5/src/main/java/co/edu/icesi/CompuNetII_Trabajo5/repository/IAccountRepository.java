package co.edu.icesi.CompuNetII_Trabajo5.repository;


import co.edu.icesi.CompuNetII_Trabajo5.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

// Una interfaz de repositorio define la capa de acceso a datos (DAO - Data Access Object).
// Al extender JpaRepository, Spring Data JPA nos proporciona automáticamente una implementación
// con los métodos CRUD (Create, Read, Update, Delete) más comunes.
public interface IAccountRepository extends JpaRepository<Account, Long> {
    // La firma de JpaRepository<T, ID> requiere dos parámetros:
    // 1. T: La clase de la entidad que este repositorio manejará (en este caso, Account).
    // 2. ID: El tipo de dato de la clave primaria de esa entidad (en este caso, Long, que corresponde al 'id' de Account).

    // No necesitamos escribir ningún método aquí por ahora, ya que JpaRepository nos da:
    // - save(Account account): Guarda o actualiza una cuenta.
    // - findById(Long id): Busca una cuenta por su ID.
    // - findAll(): Devuelve todas las cuentas.
    // - deleteById(Long id): Elimina una cuenta por su ID.
    // - count(): Cuenta el número total de cuentas.
}
