package org.kk.tirelist.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "votes")
public class VoteModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item_id", nullable=false)
    private Long itemId;
    @Column(name = "tire_id", nullable=false)
    private Long tireId;
    @Column(name = "user_id", nullable=false)
    private Long userId;
    @Column(name = "value", nullable=false)
    private int value;
    @Column(name="created_on", nullable=false)
    private LocalDateTime createdOn;

    public VoteModel() {
    }

    public VoteModel(
        @JsonProperty("itemId") Long itemId, 
        @JsonProperty("tireId") Long tireId, 
        @JsonProperty("userId") Long userId, 
        @JsonProperty("value") int value, 
        @JsonProperty("createdOn") LocalDateTime createdOn
    ) {
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
    public int getValue() { return value; }
    public LocalDateTime getCreatedOn() { return createdOn; }
    
    public void setId(Long id) { this.id = id; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
    public void setTireId(Long tireId) { this.tireId = tireId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setValue(int value) { this.value = value; }
    public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn; }
}
