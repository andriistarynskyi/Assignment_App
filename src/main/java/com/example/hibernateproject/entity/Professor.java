package com.example.hibernateproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Professor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "university_id")
    private University university;

    public Professor() {
    }

    public Professor(String name, University university) {
        this.name = name;
        this.university = university;
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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", university=" + university +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        Professor professor = (Professor) o;
        return getId() == professor.getId() && getName().equals(professor.getName()) && getUniversity().equals(professor.getUniversity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getUniversity());
    }
}
