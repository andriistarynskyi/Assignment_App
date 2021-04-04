package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.University;

public interface IUniversityRepository {

    void save(University university);

    University findById(int id);
}
