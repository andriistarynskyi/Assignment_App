package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfessorRepository extends JpaRepository<Professor, Integer> {
    List<Professor> findByName(String name);
}
