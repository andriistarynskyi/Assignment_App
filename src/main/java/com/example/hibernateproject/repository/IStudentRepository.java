package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name);
}
