package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Assignment;
import com.example.hibernateproject.entity.dto.AssignmentDTO;

import java.util.Optional;

public interface IMapService {
    Assignment getAssignment(AssignmentDTO assignmentDTO);

    AssignmentDTO getAssigmentDTO(Assignment assignment);
}
