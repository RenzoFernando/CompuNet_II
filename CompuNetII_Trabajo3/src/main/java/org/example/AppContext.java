package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Esta clase implementa el patrón Singleton para proporcionar una única instancia
 * del ApplicationContext de Spring a toda la aplicación.
 * Actúa como un punto de acceso centralizado al contenedor de IoC de Spring.
 */
public class AppContext {

    // 'applicationContext' es la representación del contenedor de IoC de Spring.
    // Se inicializa de forma estática, lo que significa que se crea una sola vez cuando la clase es cargada.
    // ClassPathXmlApplicationContext carga la configuración desde un archivo XML ubicado en el classpath (como 'context.xml').
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

    /**
     * El constructor es privado para prevenir que se creen nuevas instancias de AppContext
     * desde fuera de la clase, asegurando así que solo exista una instancia (patrón Singleton).
     */
    private AppContext(){}

    /**
     * Método estático que devuelve la única instancia del ApplicationContext.
     * Cualquier parte de la aplicación puede llamar a AppContext.getInstance() para
     * obtener acceso al contenedor de Spring y solicitar los beans que necesite.
     * @return La instancia del ApplicationContext de Spring.
     */
    public static ApplicationContext getInstance(){
        return applicationContext;
    }

}
