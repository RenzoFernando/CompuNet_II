# Apuntes de Comandos - Computación en Internet II

Aquí hay una recopilación de los comandos más importantes para trabajar con Maven, gestionar variables de entorno en Ubuntu y configurar el despliegue en IntelliJ IDEA.

## Comandos Esenciales de Maven

Maven es nuestra herramienta para construir y gestionar el proyecto. Se ejecuta desde la raíz del proyecto (donde está el archivo `pom.xml`).

-   **`mvn clean package`**
    -   **`clean`**: Borra la carpeta `target/`, que contiene los resultados de compilaciones anteriores. Es una buena práctica para asegurar una construcción limpia.
    -   **`package`**: Compila todo el código fuente, ejecuta los tests y empaqueta el resultado en un archivo final. Para un proyecto web, crea un archivo **`.war`** (Web Application Archive) dentro de la carpeta `target/`.

-   **`mvn archetype:generate -D...`**
    -   Crea un nuevo proyecto a partir de una plantilla (arquetipo). Es el comando que usamos para generar el esqueleto inicial de nuestra aplicación web.

-   **`mvn install`**
    -   Hace lo mismo que `package`, pero además, copia el archivo `.war` (o `.jar`) resultante a tu repositorio local de Maven (ubicado en `~/.m2/repository/`). Esto es útil si tienes otros proyectos en tu máquina que dependen de este.

-   **`mvn dependency:tree`**
    -   Un comando muy útil para depurar. Muestra un árbol con todas las dependencias de tu proyecto, incluyendo las dependencias de tus dependencias (dependencias transitivas). Ayuda a encontrar conflictos de versiones.

---

## Variables de Entorno en Ubuntu

Las variables de entorno le dicen al sistema operativo dónde encontrar programas importantes como Java (`JAVA_HOME`).

### Método 1: Permanente y para todo el sistema (Recomendado para JAVA_HOME)

Se edita el archivo `/etc/environment`. Este método es ideal para rutas de sistema porque no depende del usuario ni de la terminal que uses.

1.  **Abrir el archivo con permisos de administrador:**
    ```bash
    sudo nano /etc/environment
    ```
2.  **Añadir las variables:**
    Agrega las líneas al final del archivo, sin `export` y con la ruta entre comillas.
    ```
    JAVA_HOME="/usr/lib/jvm/java-21-openjdk-amd64"
    ```
3.  **Recargar las variables:**
    Para que el cambio aplique en tu sesión actual sin reiniciar, ejecuta:
    ```bash
    source /etc/environment
    ```

### Método 2: Permanente y solo para tu usuario

Se edita el archivo `~/.bashrc` (o `~/.zshrc` si usas Zsh). Los cambios se aplican solo a tu usuario cada vez que abres una nueva terminal.

1.  **Abrir el archivo:**
    ```bash
    nano ~/.bashrc
    ```
2.  **Añadir la variable al final:**
    Aquí sí se usa la palabra `export`.
    ```bash
    export OTRA_VARIABLE="algun_valor"
    ```
3.  **Recargar la configuración:**
    ```bash
    source ~/.bashrc
    ```
---

## Configuración y Despliegue en IntelliJ IDEA 

Estos son los pasos resumidos para ejecutar un proyecto web con un servidor Tomcat directamente desde el IDE.

1.  **Crear la Configuración de Ejecución:**
    -   Ir a **`Add Configuration...`** en la esquina superior derecha.
    -   Hacer clic en `+` y seleccionar **`Tomcat Server > Local`**.
    -   Darle un nombre (ej: "Mi Servidor Tomcat").
    -   En la sección `Application server`, configurar la ruta a la carpeta de Tomcat (ej: `~/apache-tomcat-11.0.9`).

2.  **Desplegar la Aplicación (Artifact):**
    -   Dentro de la misma ventana de configuración, ir a la pestaña **`Deployment`**.
    -   Hacer clic en `+` > **`Artifact...`** > y seleccionar la opción que termina en **`:war exploded`**.
    -   **Importante**: Cambiar el **`Application context`** a la ruta deseada en la URL (ej: `/mi-webapp`).

3.  **Ejecutar:**
    -   Hacer clic en el botón de **Play** para que IntelliJ construya el proyecto, inicie Tomcat y despliegue la aplicación automáticamente.