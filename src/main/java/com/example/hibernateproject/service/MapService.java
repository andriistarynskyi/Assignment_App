package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Assignment;
import com.example.hibernateproject.entity.Comment;
import com.example.hibernateproject.entity.Professor;
import com.example.hibernateproject.entity.Student;
import com.example.hibernateproject.entity.dto.AssignmentDTO;
import com.example.hibernateproject.entity.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService implements IMapService {
    private IProfessorService professorService;
    private IStudentService studentService;
    private ICommentService commentService;

    @Autowired
    public MapService(IProfessorService professorService,
                      IStudentService studentService,
                      ICommentService commentService) {
        this.professorService = professorService;
        this.studentService = studentService;
        this.commentService = commentService;
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
        return (new AssignmentDTO(assignment.getId(),
                assignment.getDescription(),
                assignment.getProfessor().getName(),
                assignment.getStudent().getName()));
    }

    @Override
    public Comment getComment(CommentDTO commentDTO, Assignment assignment) {
        return (new Comment(commentDTO.getCommentText(),
                assignment.getStudent(),
                assignment));
    }

    @Override
    public CommentDTO getCommentDTO(Comment comment) {
        return (new CommentDTO(comment.getCommentText()));
    }
}