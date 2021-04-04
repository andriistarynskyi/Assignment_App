package com.example.hibernateproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Assignment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @ManyToOne
    @JoinColumn (name = "professor_Id")
    private Professor professor;
    @OneToOne
    private Student student;

    public Assignment() {
    }

    public Assignment(String description, Professor professor, Student student) {
        this.description = description;
        this.professor = professor;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", professor=" + professor +
                ", student=" + student +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assignment)) return false;
        Assignment that = (Assignment) o;
        return id == that.id && description.equals(that.description) && professor.equals(that.professor) && getStudent().equals(that.getStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, professor, getStudent());
    }
}
