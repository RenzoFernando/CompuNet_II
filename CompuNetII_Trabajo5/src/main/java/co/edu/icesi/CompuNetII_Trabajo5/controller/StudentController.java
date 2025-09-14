package co.edu.icesi.CompuNetII_Trabajo5.controller;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Student;
import co.edu.icesi.CompuNetII_Trabajo5.repository.IStudentRepository;
import co.edu.icesi.CompuNetII_Trabajo5.service.IAccountService;
import co.edu.icesi.CompuNetII_Trabajo5.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController es una combinación de @Controller y @ResponseBody.
// Le dice a Spring que esta clase manejará peticiones web y que los valores devueltos por sus métodos
// deben ser escritos directamente en el cuerpo de la respuesta (generalmente como JSON).
@RestController
public class StudentController {

    // --- INYECCIÓN DE DEPENDENCIAS ---

    @Autowired
    // @Qualifier le dice a Spring exactamente QUÉ implementación de StudentService debe inyectar.
    // Aunque ahora solo tenemos una ("studentServiceImpl"), es una buena práctica usarlo si planeas
    // tener múltiples implementaciones en el futuro (por ejemplo, una que lea de un archivo CSV).
    // El nombre "studentServiceImpl" corresponde al nombre del bean que Spring creó para nuestra clase de servicio.
    @Qualifier("studentServiceImpl")
    private IStudentService studentService;

    // Inyectamos la interfaz del servicio de cuentas. Spring buscará la clase que la implementa (@Service) y la proporcionará.
    @Autowired
    private IAccountService accountService;

    // También estamos inyectando el repositorio directamente. Aunque es posible, generalmente
    // se considera mejor práctica que el controlador solo hable con la capa de servicio
    // para mantener una separación clara de responsabilidades.
    @Autowired
    private IStudentRepository studentRepository;


    // --- ENDPOINTS (Puntos de Acceso a la API) ---

    // @GetMapping("transfer") mapea las peticiones HTTP GET a la URL "/transfer".
    // Cuando alguien acceda a http://localhost:8080/transfer, este método se ejecutará.
    @GetMapping("transfer")
    public String transfer(){
        // Llama al método de servicio que contiene la lógica transaccional.
        accountService.transferMoney(1L,2L, 300.0);
        return "transfer"; // Devuelve un simple string como respuesta.
    }

    // Mapea las peticiones GET a "/count".
    @GetMapping("count")
    public String getStudentCount() {
        // Llama al servicio para obtener el número de estudiantes.
        long count = studentService.getCount();
        // Devuelve el resultado en un string formateado.
        return "Estudiantes: " + count;
    }

    // Mapea las peticiones GET a "/students".
    @GetMapping("students")
    public String getStudents() {
        // StringBuilder es una forma eficiente de construir strings en Java.
        StringBuilder output = new StringBuilder();
        // Llama al servicio para obtener la lista de todos los estudiantes.
        for (Student student : studentService.getStudents()) {
            // Concatena el nombre de cada estudiante.
            output.append(student.getName());
        }
        return output.toString();
    }
}
