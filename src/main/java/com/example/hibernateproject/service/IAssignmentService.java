package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Assignment;

import java.util.List;
import java.util.Optional;

public interface IAssignmentService {
    void save(Assignment assignment);

    Optional<Assignment> findById(int id);

    List<Assignment> findAll();
}