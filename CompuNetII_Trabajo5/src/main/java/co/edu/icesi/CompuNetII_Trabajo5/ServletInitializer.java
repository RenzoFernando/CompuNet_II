package co.edu.icesi.CompuNetII_Trabajo5;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Esta clase es necesaria SOLO cuando empaquetas tu aplicación como un archivo WAR para desplegarlo
// en un contenedor de servlets externo y tradicional (como una instancia separada de Apache Tomcat, JBoss, etc.).
// Si ejecutas tu aplicación como un JAR independiente (que es lo más común con Spring Boot), esta clase no se utiliza.
public class ServletInitializer extends SpringBootServletInitializer {

    // Este método se invoca por el contenedor de servlets para configurar la aplicación.
    // Le dice al contenedor cómo debe arrancar la aplicación Spring Boot.
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // .sources(IntroSpringbootApplication.class) le indica que la clase principal de configuración
        // es IntroSpringbootApplication.class, la misma que se usa en el método main.
        return application.sources(CompuNetIITrabajo5Application.class);
    }

}
