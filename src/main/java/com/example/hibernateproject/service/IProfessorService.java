package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Professor;

import java.util.List;
import java.util.Optional;

public interface IProfessorService {

    void save(Professor professor);

    Optional<Professor> findById(int id);

    List<Professor> findAll();

    List<Professor> findByName(String name);
}
