package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Professor;

public interface IProfessorRepository {
    void save(Professor professor);

    Professor findById(int id);
}
