package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Professor;
import com.example.hibernateproject.repository.IProfessorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService implements IProfessorService {
    private final IProfessorRepository professorRepository;

    public ProfessorService(IProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    @Transactional
    public void save(Professor professor) {
        professorRepository.save(professor);
    }

    @Override
    public Optional<Professor> findById(int id) {
        return professorRepository.findById(id);
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }
}