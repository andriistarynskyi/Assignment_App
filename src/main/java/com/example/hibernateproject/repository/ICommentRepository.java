package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment, Integer> {
}
