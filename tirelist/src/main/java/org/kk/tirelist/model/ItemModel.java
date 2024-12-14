package org.kk.tirelist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import net.minidev.json.JSONArray;

@Entity
@Table(name = "items")
public class ItemModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "item_name")
    private String itemName;
    @NotBlank
    @Column(name = "description")
    private String description;
    @NotBlank
    @Column(name = "image")
    private String image;
    @NotBlank
    @Column(name = "category")
    private Long category;  // 0-Character, 1-Weapon etc..
    @Column(name = "tier_id")
    private Long tireId;
    @Column(name = "meta_data")
    private JSONArray metaData;
    @Column(name = "is_active")
    private boolean isActive;

    public ItemModel() {
    }

    public ItemModel(
        @JsonProperty("itemName") String itemName, 
        @JsonProperty("description") String description, 
        @JsonProperty("image") String image, 
        @JsonProperty("category") Long category, 
        @JsonProperty("tireId") Long tireId,
        @JsonProperty("metaData") JSONArray metaData,
        @JsonProperty("isActive") boolean isActive
    ) {
        this.itemName = itemName;
        this.description = description;
        this.image = image;
        this.category = category;
        this.tireId = tireId;
        this.metaData = metaData;
        this.isActive = isActive;
    }

    public Long getId() { return id; }
    public String getItemName() { return itemName; }
    public String getDescription() { return description; }
    public String getImage() { return image; }
    public Long getCategory() { return category; }
    public Long getTireId() { return tireId; }
    public JSONArray getMetaData() { return metaData; }
    public boolean getIsActive() { return isActive; }
    
    public void setId(Long id) { this.id = id; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setDescription(String description) { this.description = description; }
    public void setImage(String image) { this.image = image; }
    public void setCategory(Long category) { this.category = category; }
    public void setTireId(Long tireId) { this.tireId = tireId; }
    public void setMetaData(JSONArray metaData) { this.metaData = metaData; }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }


}
