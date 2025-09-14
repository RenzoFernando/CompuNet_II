package co.edu.icesi.CompuNetII_Trabajo5.service;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Professor;
import java.util.List;

/**
 * Interfaz para el servicio que maneja la lógica de negocio de los profesores.
 * Definir una interfaz es una buena práctica para el desacoplamiento.
 */
public interface IProfessorService {

    /**
     * Obtiene una lista de todos los profesores registrados en la base de datos.
     * @return Una lista de entidades Professor.
     */
    List<Professor> getAllProfessors();
}
