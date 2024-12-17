package org.kk.tirelist.dto.template;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import org.kk.tirelist.dto.Item.ItemDto;
import org.kk.tirelist.model.ItemModel;

public class TemplateDto {
    private Long id;
    private String templateName;
    private String description;
    private List<ItemDto> itemList;

    public TemplateDto() {
    }

    public TemplateDto(Long id, String templateName, String description, List<ItemDto> itemList) {
        this.id = id;
        this.templateName = templateName;
        this.description = description;
        this.itemList = itemList;
    }

    public Long getId() { return id; }
    public String getTemplateName() { return templateName; }
    public String getDescription() { return description; }
    public List<ItemDto> getItemList() { return itemList; }
    
    public void setId(Long id) { this.id = id; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }
    public void setDescription(String description) { this.description = description; }
    public void setItemList(List<ItemDto> itemList) { this.itemList = itemList; }
}
