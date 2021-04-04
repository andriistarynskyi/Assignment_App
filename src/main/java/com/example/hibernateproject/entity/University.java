package com.example.hibernateproject.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "university", fetch = FetchType.EAGER)
    private List<Professor> professors;

    public University() {
    }

    public University(String name) {
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

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", professors=" + professors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof University)) return false;
        University that = (University) o;
        return getId() == that.getId() && getName().equals(that.getName()) && getProfessors().equals(that.getProfessors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getProfessors());
    }
}
