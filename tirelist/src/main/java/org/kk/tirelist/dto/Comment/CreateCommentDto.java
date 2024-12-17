package org.kk.tirelist.dto.Comment;

import java.time.LocalDateTime;

public class CreateCommentDto {
    private Long tireId;
    private Long userId;
    private String comment;

    public CreateCommentDto() {
    }

    public CreateCommentDto(Long tireId, Long userId, String comment) {
        this.tireId = tireId;
        this.userId = userId;
        this.comment = comment;
    }

    public Long getTireId() { return tireId; }
    public Long getUserId() { return userId; }
    public String getComment() { return comment; }
    
    public void setTireId(Long tireId) { this.tireId = tireId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setComment(String comment) { this.comment = comment; }
}
