package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.University;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UniversityRepository implements IUniversityRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(University university) {
        em.persist(university);
    }

    @Override
    public University findById(int id) {
        return em.find(University.class, id);
    }
}
