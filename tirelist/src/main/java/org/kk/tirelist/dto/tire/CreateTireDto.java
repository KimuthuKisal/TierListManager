package org.kk.tirelist.dto.tire;

import java.time.LocalDateTime;

public class CreateTireDto {
    private String tireName;
    private String description;
    private Long createdBy;
    private boolean visibility;
    private int rowCount;
    private int rowCapacity;
    private int holderCapacity;

    public CreateTireDto() {
    }

    public CreateTireDto(String tireName, String description, Long createdBy, boolean visibility, int rowCount, int rowCapacity, int holderCapacity) {
        this.tireName = tireName;
        this.description = description;
        this.createdBy = createdBy;
        this.visibility = visibility;
        this.rowCount = rowCount;
        this.rowCapacity = rowCapacity;
        this.holderCapacity = holderCapacity;
    }

    public String getTireName() { return tireName; }
    public String getDescription() { return description; }
    public Long getCreatedBy() { return createdBy; }
    public boolean getVisibility() { return visibility; }
    public int getRowCount() { return rowCount; }
    public int getRowCapacity() { return rowCapacity; }
    public int getHolderCapacity() { return holderCapacity; }
    
    public void setTireName(String tireName) { this.tireName = tireName; }
    public void setDescription(String description) { this.description = description; }
    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }
    public void setVisibility(boolean visibility) { this.visibility = visibility; }
    public void setRowCount(int rowCount) { this.rowCount = rowCount; }
    public void setRowCapacity(int rowCapacity) { this.rowCapacity = rowCapacity; }
    public void setHolderCapacity(int holderCapacity) { this.holderCapacity = holderCapacity; }
}
