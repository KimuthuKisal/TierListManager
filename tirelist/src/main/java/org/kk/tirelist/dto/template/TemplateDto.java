package org.kk.tirelist.dto.template;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class TemplateDto {
    private Long id;
    private String templateName;
    private String description;
    private List<Long> itemList;

    public TemplateDto() {
    }

    public TemplateDto(Long id, String templateName, String description, List<Long> itemList) {
        this.id = id;
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
}
