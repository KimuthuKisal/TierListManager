package org.kk.tirelist.dto.tire;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class TireDto {
    private Long id;
    private String tireName;
    private String description;
    private Long createdBy;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private int visibility;

    public TireDto() {
    }

    public TireDto(Long id, String tireName, String description, Long createdBy, LocalDateTime createdOn, LocalDateTime updatedOn, int visibility) {
        this.id = id;
        this.tireName = tireName;
        this.description = description;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.visibility = visibility;
    }

    public Long getId() { return id; }
    public String getTireName() { return tireName; }
    public String getDescription() { return description; }
    public Long getCreatedBy() { return createdBy; }
    public LocalDateTime getCreatedOn() { return createdOn; }
    public LocalDateTime getUpdatedOn() { return updatedOn; }
    public int getVisibility() { return visibility; }
    
    public void setId(Long id) { this.id = id; }
    public void setTireName(String tireName) { this.tireName = tireName; }
    public void setDescription(String description) { this.description = description; }
    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }
    public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn; }
    public void setUpdatedOn(LocalDateTime updatedOn) { this.updatedOn = updatedOn; }
    public void setVisibility(int visibility) { this.visibility = visibility; }
}
