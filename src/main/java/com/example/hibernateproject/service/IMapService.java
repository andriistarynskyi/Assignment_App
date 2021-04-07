package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Assignment;
import com.example.hibernateproject.entity.dto.AssignmentDTO;

public interface IMapService {
    Assignment getAssignment(AssignmentDTO assignmentDTO);

    AssignmentDTO getAssigmentDTO(Assignment assignment);
}
