package org.example.CompuNetII_Trabajo6.service;

import org.example.CompuNetII_Trabajo6.entity.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {
    List<Professor> findAll();
    Optional<Professor> findById(Integer id);
    Professor save(Professor professor);
    void deleteById(Integer id);
}
