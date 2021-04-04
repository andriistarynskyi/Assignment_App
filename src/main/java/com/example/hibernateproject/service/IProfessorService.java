package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Professor;

public interface IProfessorService {

    void save(Professor professor);

    Professor findById(int id);
}
