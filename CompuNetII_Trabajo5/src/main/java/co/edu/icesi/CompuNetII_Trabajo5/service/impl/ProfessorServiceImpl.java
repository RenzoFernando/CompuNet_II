package co.edu.icesi.CompuNetII_Trabajo5.service.impl;

import co.edu.icesi.CompuNetII_Trabajo5.entity.Professor;
import co.edu.icesi.CompuNetII_Trabajo5.repository.IProfessorRepository;
import co.edu.icesi.CompuNetII_Trabajo5.service.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// La anotación @Service le dice a Spring que esta clase es un componente de servicio
// y que debe ser gestionado por el contenedor de Spring.
@Service
public class ProfessorServiceImpl implements IProfessorService {

    // Inyectamos el repositorio de profesores para poder interactuar con la base de datos.
    @Autowired
    private IProfessorRepository professorRepository;

    /**
     * Llama al método findAll() del repositorio para obtener todos los profesores.
     * @return La lista completa de profesores.
     */
    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }
}
