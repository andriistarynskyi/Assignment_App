package com.example.hibernateproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Professor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Professor() {
    }

    public Professor(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        Professor professor = (Professor) o;
        return getId() == professor.getId() && getName().equals(professor.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}