package com.example.hibernateproject.repository;

import com.example.hibernateproject.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {
        if (user.getId() == 0) {
            em.persist(user);
        } else {
            em.merge(user);
        }
    }

    @Override
    public List<User> findAll() {
        String txt = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(txt, User.class);
        return query.getResultList();
    }

    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void removeUser(int id) {
        User user = findById(id);
        if (!user.equals(null)) {
            em.remove(user);
        } else {
            System.out.println("User with such id is not exist in the db.");
        }
    }

    @Override
    public void removeUser(User user) {
        if (user.getId() != 0) {
            em.remove(user);
        } else {
            System.out.println("Now such user in the db.");
        }
    }

    @Override
    public User findByName(String name) {
        String txt = "SELECT u FROM User u WHERE u.name = :name";
        TypedQuery<User> query = em.createQuery(txt, User.class).setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public boolean updateUser(User user) {
        if (user != null) {
            return true;
        }
        return false;
    }
}