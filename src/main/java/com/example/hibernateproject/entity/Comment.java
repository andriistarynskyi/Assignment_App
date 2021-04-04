package com.example.hibernateproject.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Comment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String commentText;
    @OneToOne
    private Student student;
    @OneToOne
    private Assignment assignment;
    @OneToMany (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "comment_id")
    private List<Comment> comment;


    public Comment() {
    }

    public Comment(String commentText, Student student, Assignment assignment) {
        this.commentText = commentText;
        this.student = student;
        this.assignment = assignment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentText='" + commentText + '\'' +
                ", student=" + student +
                ", assignment=" + assignment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return getId() == comment.getId() && getCommentText().equals(comment.getCommentText()) && getStudent().equals(comment.getStudent()) && getAssignment().equals(comment.getAssignment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCommentText(), getStudent(), getAssignment());
    }
}
