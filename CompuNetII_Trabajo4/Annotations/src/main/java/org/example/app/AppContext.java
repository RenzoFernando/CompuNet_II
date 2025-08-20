package org.example.app;

import org.example.config.AppConfig; // Importamos la nueva clase de configuración
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppContext {

    /**
     * !!! AQUI!!!
     * En lugar de pasar el nombre del paquete para que lo escanee, ahora le pasamos
     * la clase de configuración 'AppConfig.class'. Spring leerá las anotaciones
     * (@ComponentScan) de esa clase para saber qué hacer.
     */
    private static ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(AppConfig.class);


    private AppContext(){}

    public static ApplicationContext getInstance(){
        return applicationContext;
    }
}
