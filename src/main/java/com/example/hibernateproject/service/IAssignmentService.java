package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Assignment;

import java.util.List;
import java.util.Optional;

public interface IAssignmentService {
    void save(Assignment assignment);

    List<Assignment> findAll();

    Optional<Assignment> findById(int id);

    void delete(Assignment assignment);
}