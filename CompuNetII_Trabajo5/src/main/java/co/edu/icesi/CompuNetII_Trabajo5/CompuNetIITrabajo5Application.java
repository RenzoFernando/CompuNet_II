package co.edu.icesi.CompuNetII_Trabajo5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication es una anotación de conveniencia que agrupa tres anotaciones muy importantes:
// 1. @Configuration: Marca la clase como una fuente de definiciones de beans para el contexto de la aplicación.
// 2. @EnableAutoConfiguration: Le dice a Spring Boot que comience a agregar beans basados en la configuración
//    del classpath, otros beans y varias configuraciones de propiedades. Por ejemplo, si detecta spring-webmvc
//    en el classpath, configurará automáticamente un DispatcherServlet.
// 3. @ComponentScan: Le dice a Spring que busque otros componentes, configuraciones y servicios en el paquete
//    'org.example.introspringboot' y sus subpaquetes, permitiéndole encontrar y registrar los controladores,
//    servicios, repositorios, etc.
@SpringBootApplication
public class CompuNetIITrabajo5Application {

    public static void main(String[] args) {
        SpringApplication.run(CompuNetIITrabajo5Application.class, args);
    }

}
