package org.kk.tirelist.dto.vote;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class VoteDto {
    private Long id;
    private Long itemId;
    private Long tireId;
    private Long userId;
    private boolean value;
    private LocalDateTime createdOn;

    public VoteDto() {
    }

    public VoteDto(Long id, Long itemId, Long tireId, Long userId, boolean value, LocalDateTime createdOn) {
        this.id = id;
        this.itemId = itemId;
        this.tireId = tireId;
        this.userId = userId;
        this.value = value;
        this.createdOn = createdOn;
    }

    public Long getId() { return id; }
    public Long getItemId() { return itemId; }
    public Long getTireId() { return tireId; }
    public Long getUserId() { return userId; }
    public boolean getValue() { return value; }
    public LocalDateTime getCreatedOn() { return createdOn; }
    
    public void setId(Long id) { this.id = id; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
    public void setTireId(Long tireId) { this.tireId = tireId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setValue(boolean value) { this.value = value; }
    public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn; }
}
