package org.kk.tirelist.dto.tire;

import java.time.LocalDateTime;

public class CreateTireDto {
    private String tireName;
    private String description;
    private Long createdBy;
    private int visibility;

    public CreateTireDto() {
    }

    public CreateTireDto(String tireName, String description, Long createdBy, int visibility) {
        this.tireName = tireName;
        this.description = description;
        this.createdBy = createdBy;
        this.visibility = visibility;
    }

    public String getTireName() { return tireName; }
    public String getDescription() { return description; }
    public Long getCreatedBy() { return createdBy; }
    public int getVisibility() { return visibility; }
    
    public void setTireName(String tireName) { this.tireName = tireName; }
    public void setDescription(String description) { this.description = description; }
    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }
    public void setVisibility(int visibility) { this.visibility = visibility; }
}
