package org.example.CompuNetII_Trabajo6.service.impl;

import org.example.CompuNetII_Trabajo6.entity.Professor;
import org.example.CompuNetII_Trabajo6.repository.ProfessorRepository;
import org.example.CompuNetII_Trabajo6.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Optional<Professor> findById(Integer id) {
        return professorRepository.findById(id);
    }

    @Override
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void deleteById(Integer id) {
        professorRepository.deleteById(id);
    }
}
