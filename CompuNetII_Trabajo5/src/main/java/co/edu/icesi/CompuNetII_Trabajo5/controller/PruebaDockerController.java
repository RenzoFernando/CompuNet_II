package co.edu.icesi.CompuNetII_Trabajo5.controller;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Professor;
import co.edu.icesi.CompuNetII_Trabajo5.service.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PruebaDockerController {

    @Autowired
    private IProfessorService professorService;

    // --- Endpoint de prueba para verificar la conexión con PostgreSQL ---
    /**
     * Este método se mapea a la URL "/profesores".
     * Cuando se accede a esta URL, llama al servicio para obtener todos los profesores
     * y los devuelve como una respuesta JSON.
     * @return Un ResponseEntity que contiene la lista de profesores y un estado HTTP 200 (OK).
     */
    @GetMapping("/profesores")
    public ResponseEntity<List<Professor>> getAllProfessors() {
        List<Professor> professors = professorService.getAllProfessors();
        return ResponseEntity.ok(professors);
    }

}
