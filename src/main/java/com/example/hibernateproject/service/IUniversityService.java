package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.University;

public interface IUniversityService {

    void save(University university);

    University findById(int id);
}
