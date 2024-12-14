package org.kk.tirelist.dto.Item;

import net.minidev.json.JSONArray;

public class CreateItemDto {
    private String itemName;
    private String description;
    private String image;
    private Long category;
    private Long tireId;
    private JSONArray metaData;
    private boolean isActive;

    public CreateItemDto(String itemName, String description, String image, Long category, Long tireId, JSONArray metaData, boolean isActive) {
        this.itemName = itemName;
        this.description = description;
        this.image = image;
        this.category = category;
        this.tireId = tireId;
        this.metaData = metaData;
        this.isActive = isActive;
    }

    public String getItemName() { return itemName; }
    public String getDescription() { return description; }
    public String getImage() { return image; }
    public Long getCategory() { return category; }
    public Long getTireId() { return tireId; }
    public JSONArray getMetaData() { return metaData; }
    public boolean getIsActive() { return isActive; }

    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setDescription(String description) { this.description = description; }
    public void setImage(String image) { this.image = image; }
    public void setCategory(Long category) { this.category = category; }
    public void setTireId(Long tireId) { this.tireId = tireId; }
    public void setMetaData(JSONArray metaData) { this.metaData = metaData; }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }

    
}
