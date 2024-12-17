package org.kk.tirelist.dto.Comment;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class CommentDto {
    private Long id;
    private Long tireId;
    private Long userId;
    private String comment;
    private LocalDateTime createdOn;

    public CommentDto() {
    }

    public CommentDto(Long id, Long tireId, Long userId, String comment, LocalDateTime createdOn) {
        this.id = id;
        this.tireId = tireId;
        this.userId = userId;
        this.comment = comment;
        this.createdOn = createdOn;
    }
    
    public Long getId() { return id; }
    public Long getTireId() { return tireId; }
    public Long getUserId() { return userId; }
    public String getComment() { return comment; }
    public LocalDateTime getCreatedOn() { return createdOn; }
    
    public void setId(Long id) { this.id = id; }
    public void setTireId(Long tireId) { this.tireId = tireId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setComment(String comment) { this.comment = comment; }
    public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn; }
}
