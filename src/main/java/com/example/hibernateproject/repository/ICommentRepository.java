package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment, Integer> {

    @Query("SELECT c FROM Comment c WHERE c.assignment.id = :id")
    List<Comment> findAllByAssignmentId(@Param("id") int id);
}