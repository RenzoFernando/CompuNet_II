package co.edu.icesi.CompuNetII_Trabajo5.entity;

import jakarta.persistence.*;

// @Entity le dice a JPA que esta clase es una entidad y debe ser mapeada a una tabla en la base de datos.
@Entity
// @Table especifica el nombre de la tabla en la base de datos. Si se omite, JPA usaría el nombre de la clase.
@Table(name = "accounts")
public class Account {
    // @Id marca este campo como la clave primaria (primary key) de la tabla.
    @Id
    // @GeneratedValue indica cómo se genera el valor de la clave primaria.
    // 'strategy = GenerationType.IDENTITY' significa que la base de datos se encargará de generar y asignar el valor
    // (por ejemplo, usando una columna autoincremental), lo cual es común en PostgreSQL y MySQL.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String owner;
    private Double balance;

    // --- Getters y Setters ---
    // Métodos estándar para acceder y modificar las propiedades privadas de la clase.
    // JPA los utiliza para interactuar con los campos de la entidad.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
