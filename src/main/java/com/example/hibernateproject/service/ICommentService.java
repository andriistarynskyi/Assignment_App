package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    void save(Comment comment);

    Optional<Comment> findById(int id);

    List<Comment> findAllByAssignmentId(int id);
}
