package org.kk.tirelist.mapper;

import org.kk.tirelist.dto.template.CreateTemplateDto;
import org.kk.tirelist.dto.template.TemplateDto;
import org.kk.tirelist.model.TemplateModel;

public class TemplateMapper {
    public static TemplateDto mapTemplateToTemplateDto(TemplateModel templateModel) {
        return new TemplateDto(
            templateModel.getId(),
            templateModel.getTemplateName(),
            templateModel.getDescription(),
            templateModel.getItemList()
        );
    }

    public static TemplateModel mapCReatetemplateDtoToTemplate(CreateTemplateDto createTemplateDto) {
        return new TemplateModel(
            createTemplateDto.getTemplateName(),
            createTemplateDto.getDescription(),
            createTemplateDto.getItemList()
        );
    }
}
