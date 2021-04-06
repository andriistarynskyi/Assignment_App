package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfessorRepository extends JpaRepository<Professor, Integer> {
}
