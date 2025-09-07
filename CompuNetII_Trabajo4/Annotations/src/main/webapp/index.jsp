<%@ page import="org.example.service.StudentService" %>
<%@ page import="org.example.app.AppContext" %>
<%@ page import="org.example.model.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Estudiantes</title>
    <!-- Enlazamos la hoja de estilos externa -->
    <link rel="stylesheet" href="style.css">
</head>

<%--

<!-- CODIGO HECHO EN CLASE -->

<body>

    <H1>Escriba</H1>
    <p>Escriba quí.</p>
    <%
        StudentService studentService = AppContext.getInstance()
                .getBean("studentService", StudentService.class);

        for(Student student : studentService.getStudents()) {
            out.println("<p>" + student.getName() + " (ID: " + student.getId() + ") - " + student.getCourseId() + "</p>");
        }
    %>

</body>
--%>

<!-- MI CODIGO A MI FORMA -->
<body>
<div class="container">
    <h1>Gestión de Estudiantes</h1>

    <!-- Formulario para registrar un nuevo estudiante -->
    <h2>Registrar Nuevo Estudiante</h2>
    <form action="student" method="POST" novalidate> <!-- 'novalidate' desactiva la validación del navegador para usar la nuestra con JS -->
        <div>
            <label for="studentId">ID:</label>
            <input type="text" id="studentId" name="studentId">
        </div>
        <div>
            <label for="studentName">Nombre:</label>
            <input type="text" id="studentName" name="studentName">
        </div>
        <div>
            <label for="courseId">ID del Curso:</label>
            <input type="text" id="courseId" name="courseId">
        </div>

        <!-- Div para mostrar los mensajes de error de JavaScript -->
        <div id="errorMessage" class="error-message"></div>

        <button type="submit">Registrar</button>
    </form>

    <hr style="margin: 30px 0;">

    <!-- Sección para mostrar la lista de estudiantes registrados -->
    <h2>Estudiantes Registrados</h2>
    <ul>
        <%
            StudentService studentService = AppContext.getInstance().getBean("studentService", StudentService.class);
            ArrayList<Student> studentList = studentService.getStudents();
            if (studentList.isEmpty()) {
                out.println("<li>No hay estudiantes registrados.</li>");
            } else {
                for (Student student : studentList) {
                    out.println("<li>" + student.getName() + " (ID: " + student.getId() + ") - " + student.getCourseId() + "</li>");
                }
            }
        %>
    </ul>
</div>

<!-- Enlazamos el archivo JavaScript externo. 'defer' asegura que se ejecute después de que el HTML sea analizado. -->
<script src="script.js" defer></script>
</body>
</html>
