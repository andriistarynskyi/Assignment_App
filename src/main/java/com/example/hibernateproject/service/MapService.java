package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Assignment;
import com.example.hibernateproject.entity.Professor;
import com.example.hibernateproject.entity.Student;
import com.example.hibernateproject.entity.dto.AssignmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService implements IMapService {
    private final IProfessorService professorService;
    private final IStudentService studentService;

    @Autowired
    public MapService(IProfessorService professorService, IStudentService studentService) {
        this.professorService = professorService;
        this.studentService = studentService;
    }

    @Override
    public Assignment getAssignment(AssignmentDTO assignmentDTO) {
        Assignment assignment = new Assignment();
        assignment.setDescription(assignmentDTO.getDescription());
        Professor professor = professorService.findByName(assignmentDTO.getProfessorName()).get(0);
        assignment.setProfessor(professor);
        Student student = studentService.findByName(assignmentDTO.getStudentName()).get(0);
        assignment.setStudent(student);
        return assignment;
    }

    @Override
    public AssignmentDTO getAssigmentDTO(Assignment assignment) {
        return (new AssignmentDTO(assignment.getDescription(),
                assignment.getProfessor().getName(),
                assignment.getStudent().getName()));
    }
}