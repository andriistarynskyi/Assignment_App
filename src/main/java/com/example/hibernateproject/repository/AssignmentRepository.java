package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Assignment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AssignmentRepository implements IAssignmentRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Assignment assignment) {
        if (assignment.getId() == 0) {
            em.persist(assignment);
        } else {
            em.merge(assignment);
        }
    }

    @Override
    public Assignment findById(int id) {
        return em.find(Assignment.class, id);
    }
}
