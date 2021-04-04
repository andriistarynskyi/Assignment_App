package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Student;

public interface IStudentRepository {

    void save(Student student);

    Student findById(int id);
}
