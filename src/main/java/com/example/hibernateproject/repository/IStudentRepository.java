package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
}
