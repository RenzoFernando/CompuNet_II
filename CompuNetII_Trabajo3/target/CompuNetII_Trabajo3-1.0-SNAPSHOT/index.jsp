<%-- Las directivas 'page' importan las clases de Java necesarias para usarlas en el código JSP. --%>
<%@ page import="org.example.AppContext" %>
<%@ page import="org.example.services.ShopService" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<%-- Esta directiva define el lenguaje de la página y la codificación de caracteres. Es importante para manejar acentos y caracteres especiales. --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Compras</title>
    <!-- Enlazamos la hoja de estilos CSS para mejorar la apariencia. -->
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h1>Mi Lista de Compras</h1>

<%--
  Un 'Scriptlet' de JSP (<% ... %>) permite escribir código Java directamente en la página.
  Este código se ejecuta en el servidor antes de que la página HTML sea enviada al navegador.
--%>
<%
    // 1. Obtenemos la instancia del servicio desde el contexto de Spring.
    ShopService service = (ShopService) AppContext.getInstance().getBean("shopService");
    // 2. Llamamos al método del servicio para obtener los datos.
    ArrayList<String> list = service.getItems();

    // 3. Generamos HTML dinámicamente para mostrar los datos.
    out.println("<h2>Items Registrados:</h2>");
    if (list.isEmpty()) {
        out.println("<p>La lista está vacía.</p>");
    } else {
        out.println("<ol>");
        for(String item : list){
            out.println("<li>" + item + "</li>");
        }
        out.println("</ol>");
    }
%>

<hr>

<h2>Añadir Nuevo Item</h2>
<%--
  Este es un formulario HTML.
  - 'method="POST"': Indica que los datos se enviarán usando una petición HTTP POST.
  - 'action="shop"': Especifica la URL a la que se enviarán los datos. Coincide con el @WebServlet("/shop") de nuestro servlet.
--%>
<form method="POST" action="shop">
    <input type="text" placeholder="Escribe tu compra" name="compra" id="compra-input" required>
    <button type="submit">Registrar</button>
</form>

<%-- Una 'Expresión' de JSP (<%= ... %>) evalúa una expresión de Java y convierte el resultado a String. --%>
<p class="footer">La fecha y hora actuales son: <%= new java.util.Date() %></p>

<!-- Enlazamos el archivo JavaScript. -->
<script src="scrip.js"></script>
</body>
</html>
