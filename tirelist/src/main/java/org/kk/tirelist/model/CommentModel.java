package org.kk.tirelist.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "comments")
public class CommentModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tire_id", nullable=false)
    private Long tireId;
    @Column(name = "user_id", nullable=false)
    private Long userId;
    @Column(name = "comment", nullable=false)
    private String comment;
    @Column(name="created_on", nullable=false)
    private LocalDateTime createdOn;

    public CommentModel() {
    }

    public CommentModel(
        @JsonProperty("tireId") Long tireId, 
        @JsonProperty("userId") Long userId, 
        @JsonProperty("comment") String comment, 
        @JsonProperty("createdOn") LocalDateTime createdOn
    ) {
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
