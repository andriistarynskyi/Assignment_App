package com.example.hibernateproject.entity.dto;

import java.util.Objects;

public class AssignmentDTO {
    private String description;
    private String professorName;
    private String studentName;

    public AssignmentDTO() {
    }

    public AssignmentDTO(String description, String professorName, String studentName) {
        this.description = description;
        this.professorName = professorName;
        this.studentName = studentName;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssignmentDTO)) return false;
        AssignmentDTO that = (AssignmentDTO) o;
        return getDescription().equals(that.getDescription()) && getProfessorName().equals(that.getProfessorName()) && getStudentName().equals(that.getStudentName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getProfessorName(), getStudentName());
    }
}