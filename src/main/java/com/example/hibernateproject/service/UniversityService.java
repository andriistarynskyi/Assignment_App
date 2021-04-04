package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.University;
import com.example.hibernateproject.repository.IUniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UniversityService implements IUniversityService{

    @Autowired
    private IUniversityRepository universityRepository;

    @Override
    @Transactional
    public void save(University university) {
        universityRepository.save(university);
    }

    @Override
    public University findById(int id) {
        return universityRepository.findById(id);
    }
}
