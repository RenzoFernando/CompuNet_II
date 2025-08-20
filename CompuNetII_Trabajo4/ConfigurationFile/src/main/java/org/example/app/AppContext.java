package org.example.app;

import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * El AppContext ahora está adaptado para leer la configuración desde una clase Java.
 */
public class AppContext {

    /**
     * ¡Este es el cambio clave!
     * En lugar de 'ClassPathXmlApplicationContext' que busca un archivo .xml,
     * ahora usamos 'AnnotationConfigApplicationContext'.
     * Le pasamos la clase 'AppConfig.class' como argumento para que sepa dónde
     * buscar las definiciones de los beans (@Bean).
     */
    private static ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(AppConfig.class);

    /**
     * Constructor privado para mantener el patrón Singleton.
     */
    private AppContext(){}

    /**
     * Método estático para obtener la instancia del contenedor de Spring.
     * Su funcionamiento no cambia para el resto de la aplicación.
     */
    public static ApplicationContext getInstance(){
        return applicationContext;
    }

}
