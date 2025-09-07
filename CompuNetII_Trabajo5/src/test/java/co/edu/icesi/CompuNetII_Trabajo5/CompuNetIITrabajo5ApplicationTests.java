package co.edu.icesi.CompuNetII_Trabajo5;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest es una anotación clave para las pruebas de integración en Spring.
// A diferencia de las pruebas unitarias que prueban una clase de forma aislada, las pruebas de integración
// cargan el contexto completo de la aplicación Spring.
// Esto significa que se inicia la aplicación, se conectan los beans, se configura la base de datos (en memoria por defecto),
// y se puede probar la interacción entre diferentes capas (Controlador -> Servicio -> Repositorio).
@SpringBootTest
class CompuNetIITrabajo5ApplicationTests {

    // @Test es la anotación de JUnit 5 que marca un método como un caso de prueba.
    @Test
    void contextLoads() {

    }

}
