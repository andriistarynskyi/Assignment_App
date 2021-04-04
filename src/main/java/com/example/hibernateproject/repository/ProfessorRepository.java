package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Professor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProfessorRepository implements IProfessorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Professor professor) {
        if(professor.getId() == 0) {
            em.persist(professor);
        } else {
            em.merge(professor);
        }
    }

    @Override
    public Professor findById(int id) {
        return em.find(Professor.class, id);
    }
}