package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Comment;

public interface ICommentRepository {

    void save(Comment comment);

    Comment findById(int id);
}
