package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Assignment;
import com.example.hibernateproject.repository.IAssignmentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService implements IAssignmentService {
    private final IAssignmentRepository assignmentRepository;

    public AssignmentService(IAssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    @Transactional
    public void save(Assignment assignment) {
        assignmentRepository.save(assignment);
    }

    @Override
    public Optional<Assignment> findById(int id) {
        return assignmentRepository.findById(id);
    }

    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }
}