package org.kk.tirelist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "templates")
public class TemplateModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "template_name")
    private String templateName;
    @NotBlank
    @Column(name = "description")
    private String description;
    @Column(name = "item_list")
    private List<Long> itemList;

    public TemplateModel() {
    }

    public TemplateModel(
            @JsonProperty("templateName") String templateName,
            @JsonProperty("description") String description,
            @JsonProperty("itemList") List<Long> itemList
    ) {
        this.templateName = templateName;
        this.description = description;
        this.itemList = itemList;
    }

    public Long getId() { return id; }
    public String getTemplateName() { return templateName; }
    public String getDescription() { return description; }
    public List<Long> getItemList() { return itemList; }
    
    public void setId(Long id) { this.id = id; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }
    public void setDescription(String description) { this.description = description; }
    public void setItemList(List<Long> itemList) { this.itemList = itemList; }

    // Add item to item list
    public void addItem(Long item) {
        if (!this.itemList.contains(item)) {
            this.itemList.add(item);
        }
    }

    // Remove item from item list
    public void removeItem(Long item) {
        if (this.itemList != null) {
            this.itemList.remove(item);
        }
    }
}
