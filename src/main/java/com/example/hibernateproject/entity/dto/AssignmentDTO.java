package com.example.hibernateproject.entity.dto;

import java.util.Objects;

public class AssignmentDTO {
    private int id;
    private String description;
    private String professorName;
    private String studentName;

    public AssignmentDTO() {
    }

    public AssignmentDTO(int id, String description, String professorName, String studentName) {
        this.id = id;
        this.description = description;
        this.professorName = professorName;
        this.studentName = studentName;
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

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "AssignmentDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", professorName='" + professorName + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignmentDTO that = (AssignmentDTO) o;
        return id == that.id && description.equals(that.description) && professorName.equals(that.professorName) && studentName.equals(that.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, professorName, studentName);
    }
}