package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class StudentRepository implements IStudentRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class, id);
    }
}
