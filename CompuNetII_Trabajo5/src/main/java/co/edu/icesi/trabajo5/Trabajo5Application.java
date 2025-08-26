// Este es el paquete principal de la aplicación. Es una buena práctica
// usar un nombre de dominio invertido (co.edu.icesi) seguido del nombre
// del proyecto (trabajo5).
package co.edu.icesi.trabajo5;

// Importa las clases necesarias de Spring Boot.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// La anotación @SpringBootApplication es un atajo para varias anotaciones
// de configuración importantes:
// @Configuration: Marca esta clase como una fuente de definiciones de beans.
// @EnableAutoConfiguration: Habilita la configuración automática de Spring Boot,
//                          que configura la aplicación basándose en las dependencias.
// @ComponentScan: Permite a Spring escanear y encontrar componentes (clases con
//                 anotaciones como @Controller, @Service, @Repository, etc.)
//                 en el mismo paquete y sus subpaquetes.
@SpringBootApplication
public class Trabajo5Application {

    // El método main es el punto de entrada de la aplicación.
    // Llama a SpringApplication.run() para arrancar la aplicación de Spring Boot.
    // A partir de aquí, Spring se encarga de todo el proceso de inicialización,
    // incluyendo la configuración del servidor web, la base de datos, etc.
    public static void main(String[] args) {
        SpringApplication.run(Trabajo5Application.class, args);
    }

}