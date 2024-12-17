package org.kk.tirelist.dto.Item;

import net.minidev.json.JSONArray;

public class UpdateItemDto {
    private Long id;
    private String itemName;
    private String description;
    private String image;
    private Long category;
    // private Long tireId;
    private JSONArray metaData;
    private boolean isActive;

    public UpdateItemDto() {
    }

    public UpdateItemDto(Long id, String itemName, String description, String image, Long category, JSONArray metaData, boolean isActive) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.image = image;
        this.category = category;
        this.metaData = metaData;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Long getCategory() {
        return category;
    }

    public JSONArray getMetaData() {
        return metaData;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public void setMetaData(JSONArray metaData) {
        this.metaData = metaData;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
