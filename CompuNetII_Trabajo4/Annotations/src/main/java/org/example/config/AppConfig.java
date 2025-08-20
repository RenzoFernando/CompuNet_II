package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * !!! ARCHIVO NUEVO Y CLAVE !!!
 * Esta es la clase de configuración principal para la versión de Anotaciones.
 * @Configuration indica que esta clase contiene configuraciones de Spring.
 * @ComponentScan le dice a Spring que escanee el paquete "org.example" (y todos sus sub-paquetes)
 * en busca de clases anotadas con @Component, @Service, @Repository, etc., para registrarlas como beans.
 * Esto elimina la necesidad de declarar cada bean manualmente.
 */
@Configuration
@ComponentScan("org.example")
public class AppConfig {
}
