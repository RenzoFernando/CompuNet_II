package org.example.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Esta clase, al igual que en el proyecto anterior, utiliza el patrón Singleton
 * para gestionar y proporcionar una única instancia del ApplicationContext de Spring.
 * Es el puente entre nuestro código de aplicación y el contenedor de IoC de Spring.
 */
public class AppContext {

    // Se crea una única instancia estática del ApplicationContext de Spring.
    // ClassPathXmlApplicationContext le indica a Spring que busque y cargue el archivo 'context.xml'
    // desde el classpath de la aplicación al iniciarse.
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

    /**
     * Constructor privado para evitar que se creen otras instancias de esta clase.
     */
    private AppContext(){}

    /**
     * Método estático público que permite a cualquier parte de la aplicación
     * obtener acceso al contenedor de Spring para solicitar los beans que necesite.
     * @return La instancia única del ApplicationContext.
     */
    public static ApplicationContext getInstance(){
        return applicationContext;
    }

}
