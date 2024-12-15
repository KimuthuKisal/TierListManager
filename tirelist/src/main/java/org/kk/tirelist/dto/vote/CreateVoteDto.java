package org.kk.tirelist.dto.vote;

import java.time.LocalDateTime;

public class CreateVoteDto {
    private Long itemId;
    private Long tireId;
    private Long userId;
    private int value;

    public CreateVoteDto() {
    }

    public CreateVoteDto(Long itemId, Long tireId, Long userId, int value) {
        this.itemId = itemId;
        this.tireId = tireId;
        this.userId = userId;
        this.value = value;
    }

    public Long getItemId() { return itemId; }
    public Long getTireId() { return tireId; }
    public Long getUserId() { return userId; }
    public int getValue() { return value; }
    
    public void setItemId(Long itemId) { this.itemId = itemId; }
    public void setTireId(Long tireId) { this.tireId = tireId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setValue(int value) { this.value = value; }
}
