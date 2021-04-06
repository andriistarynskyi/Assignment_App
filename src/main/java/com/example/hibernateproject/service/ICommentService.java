package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Comment;

import java.util.Optional;

public interface ICommentService {
    void save(Comment comment);

    Optional<Comment> findById(int id);
}
