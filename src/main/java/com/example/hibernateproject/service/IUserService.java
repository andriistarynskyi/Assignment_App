package com.example.hibernateproject.service;

import com.example.hibernateproject.entity.User;

import java.util.List;

public interface IUserService {
    void save(User user);

    List<User> findAll();

    User findById(int id);

    void removeUser(int id);

    void removeUser(User user);

    User findByName(String name);

}
