package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;

@Repository
public class CommentRepository implements ICommentRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Comment comment) {
        em.persist(comment);
    }

    @Override
    public Comment findById(int id) {
        return em.find(Comment.class, id);
    }
}
