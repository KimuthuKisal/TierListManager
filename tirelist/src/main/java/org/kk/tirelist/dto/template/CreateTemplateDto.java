package org.kk.tirelist.dto.template;

import java.util.List;

public class CreateTemplateDto {
    private String templateName;
    private String description;
    private List<Long> itemList;

    public CreateTemplateDto() {
    }

    public CreateTemplateDto(String templateName, String description, List<Long> itemList) {
        this.templateName = templateName;
        this.description = description;
        this.itemList = itemList;
    }

    public String getTemplateName() { return templateName; }
    public String getDescription() { return description; }
    public List<Long> getItemList() { return itemList; }
    
    public void setTemplateName(String templateName) { this.templateName = templateName; }
    public void setDescription(String description) { this.description = description; }
    public void setItemList(List<Long> itemList) { this.itemList = itemList; }
}
