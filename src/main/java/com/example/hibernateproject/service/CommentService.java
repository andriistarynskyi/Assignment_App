package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Comment;
import com.example.hibernateproject.repository.ICommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    private final ICommentRepository commentRepository;

    public CommentService(ICommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    @Transactional
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> findById(int id) {
        return commentRepository.findById(id);
    }
}