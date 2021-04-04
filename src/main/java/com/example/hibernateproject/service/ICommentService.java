package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Comment;

public interface ICommentService {
    void save(Comment comment);

    Comment findById(int id);
}
