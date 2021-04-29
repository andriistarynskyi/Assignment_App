package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Assignment;
import com.example.hibernateproject.entity.Comment;
import com.example.hibernateproject.entity.dto.AssignmentDTO;
import com.example.hibernateproject.entity.dto.CommentDTO;

import java.util.Optional;

public interface IMapService {
    Assignment getAssignment(AssignmentDTO assignmentDTO);

    AssignmentDTO getAssigmentDTO(Assignment assignment);

    Comment getComment(CommentDTO commentDTO, Assignment assignment);

    CommentDTO getCommentDTO(Comment comment);
}
