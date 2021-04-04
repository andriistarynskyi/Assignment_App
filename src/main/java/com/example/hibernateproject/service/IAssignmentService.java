package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Assignment;

public interface IAssignmentService {
    void save(Assignment assignment);

    Assignment findById(int id);
}
