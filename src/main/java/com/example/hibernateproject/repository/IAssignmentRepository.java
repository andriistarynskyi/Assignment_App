package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Assignment;

public interface IAssignmentRepository {
    void save(Assignment assignment);

    Assignment findById(int id);
}
