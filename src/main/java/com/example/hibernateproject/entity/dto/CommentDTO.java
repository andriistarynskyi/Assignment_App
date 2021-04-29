package com.example.hibernateproject.entity.dto;

import java.util.Objects;

public class CommentDTO {
    private String commentText;

    public CommentDTO() {
    }

    public CommentDTO(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "commentText='" + commentText + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDTO that = (CommentDTO) o;
        return commentText.equals(that.commentText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentText);
    }
}
