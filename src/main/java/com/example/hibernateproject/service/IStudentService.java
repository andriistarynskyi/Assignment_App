package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    void save(Student student);

    Optional<Student> findById(int id);

    List<Student> findAll();
}
