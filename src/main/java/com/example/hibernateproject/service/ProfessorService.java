package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Professor;
import com.example.hibernateproject.repository.IProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProfessorService implements IProfessorService{
    @Autowired
    private IProfessorRepository professorRepository;

    @Override
    @Transactional
    public void save(Professor professor) {
        professorRepository.save(professor);
    }

    @Override
    public Professor findById(int id) {
        return professorRepository.findById(id);
    }
}
