package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Assignment;
import com.example.hibernateproject.repository.IAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AssignmentService implements IAssignmentService{

    @Autowired
    private IAssignmentRepository assignmentRepository;

    @Override
    @Transactional
    public void save(Assignment assignment) {
        assignmentRepository.save(assignment);
    }

    @Override
    public Assignment findById(int id) {
        return assignmentRepository.findById(id);
    }
}
