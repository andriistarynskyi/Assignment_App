package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAssignmentRepository extends JpaRepository<Assignment, Integer> {
}