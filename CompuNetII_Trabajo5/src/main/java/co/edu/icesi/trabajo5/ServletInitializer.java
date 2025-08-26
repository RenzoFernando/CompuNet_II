package co.edu.icesi.trabajo5;

// Importa las clases necesarias para configurar la aplicación web.
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Esta clase es necesaria para desplegar la aplicación como un archivo WAR
// en un servidor de aplicaciones externo, como Tomcat. Extiende
// SpringBootServletInitializer para integrar la aplicación con el
// ciclo de vida del servlet.
public class ServletInitializer extends SpringBootServletInitializer {

    // El método configure() es llamado por el contenedor de servlets (e.g., Tomcat)
    // para configurar la aplicación Spring. Retorna un SpringApplicationBuilder
    // que indica la clase principal de la aplicación (Trabajo5Application.class).
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Trabajo5Application.class);
    }

}