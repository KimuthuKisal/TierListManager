package org.kk.tirelist.dto.tire;

import java.time.LocalDateTime;
import java.util.List;

import org.kk.tirelist.dto.UserModel.UserDto;

public class TireDto {
    private Long id;
    private String tireName;
    private String description;
    private UserDto createdBy;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private boolean visibility;
    private int rowCount;
    private int rowCapacity;
    private int holderCapacity;
    private List<TireRowDto> rows;
    private List<TireHolderDto> holderItems;

    public TireDto() {
    }

    public TireDto(Long id, String tireName, String description, UserDto createdBy, LocalDateTime createdOn, LocalDateTime updatedOn, boolean visibility, int rowCount, int rowCapacity, int holderCapacity, List<TireRowDto> rows, List<TireHolderDto> holderItems) {
        this.id = id;
        this.tireName = tireName;
        this.description = description;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.visibility = visibility;
        this.rowCount = rowCount;
        this.rowCapacity = rowCapacity;
        this.holderCapacity = holderCapacity;
        this.rows = rows;
        this.holderItems = holderItems;
    }

    public Long getId() { return id; }
    public String getTireName() { return tireName; }
    public String getDescription() { return description; }
    public UserDto getCreatedBy() { return createdBy; }
    public LocalDateTime getCreatedOn() { return createdOn; }
    public LocalDateTime getUpdatedOn() { return updatedOn; }
    public boolean getVisibility() { return visibility; }
    public int getRowCount() { return rowCount; }
    public int getRowCapacity() { return rowCapacity; }
    public int getHolderCapacity() { return holderCapacity; }
    public List<TireRowDto> getRows() { return rows; }
    public List<TireHolderDto> getHolderItems() { return holderItems; }

    public void setId(Long id) { this.id = id; }
    public void setTireName(String tireName) { this.tireName = tireName; }
    public void setDescription(String description) { this.description = description; }
    public void setCreatedBy(UserDto createdBy) { this.createdBy = createdBy; }
    public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn; }
    public void setUpdatedOn(LocalDateTime updatedOn) { this.updatedOn = updatedOn; }
    public void setVisibility(boolean visibility) { this.visibility = visibility; }
    public void setRowCount(int rowCount) { this.rowCount = rowCount; }
    public void setRowCapacity(int rowCapacity) { this.rowCapacity = rowCapacity; }
    public void setHolderCapacity(int holderCapacity) { this.holderCapacity = holderCapacity; }
    public void setRows(List<TireRowDto> rows) { this.rows = rows; }
    public void setHolderItems(List<TireHolderDto> holderItems) { this.holderItems = holderItems; }
}
