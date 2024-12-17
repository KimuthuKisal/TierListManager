package org.kk.tirelist.dto.template;

import org.kk.tirelist.dto.Item.ItemDto;

import java.util.List;

public class UpdateTemplateDto {
    private Long id;
    private String templateName;
    private String description;

    public UpdateTemplateDto() {
    }

    public UpdateTemplateDto(Long id, String templateName, String description) {
        this.id = id;
        this.templateName = templateName;
        this.description = description;
    }

    public Long getId() { return id; }
    public String getTemplateName() { return templateName; }
    public String getDescription() { return description; }

    public void setId(Long id) { this.id = id; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }
    public void setDescription(String description) { this.description = description; }
}
