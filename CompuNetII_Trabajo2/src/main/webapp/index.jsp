<%--
  --- NOTA DE DIRECTIVA DE PÁGINA JSP ---
  La línea `<%@ page ... %>` es una directiva. Le da instrucciones al servidor sobre cómo procesar esta página.
  - contentType="text/html;charset=UTF-8":
    - 'text/html': Le dice al navegador que esta página es HTML.
    - 'charset=UTF-8': Especifica la codificación de caracteres. UTF-8 es el estándar y permite usar
      tildes, eñes y otros símbolos sin problemas.
  - language="java": Indica que el lenguaje de programación que se puede usar dentro de esta página es Java.

  --- NOTA CLAVE SOBRE JSP (JavaServer Pages) ---
  Un archivo JSP es básicamente un archivo HTML con la capacidad de ejecutar código Java.
  Cuando un usuario solicita este archivo por primera vez, el servidor Tomcat lo traduce y compila
  en una clase de Servlet (muy parecida a nuestro ServletExample.java). En las siguientes peticiones,
  ya usa esa clase compilada, lo que lo hace muy eficiente.
  Es ideal para crear las vistas (la parte visual) de una aplicación web.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- Esto es HTML estándar. El servidor lo enviará tal cual al navegador del cliente. --%>
<h1>Beta Gamma Alfa Delta</h1>
</body>
</html>