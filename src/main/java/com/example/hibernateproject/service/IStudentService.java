package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.Student;

public interface IStudentService {

    void save(Student student);

    Student findById(int id);
}
