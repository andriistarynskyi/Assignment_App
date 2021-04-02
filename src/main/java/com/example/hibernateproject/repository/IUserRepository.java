package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.User;

import java.util.List;

public interface IUserRepository {
    void save(User user);

    List<User> findAll();

    User findById(int id);

    void removeUser(int id);

    void removeUser(User user);

    boolean updateUser(User user);

    User findByName(String name);
}
