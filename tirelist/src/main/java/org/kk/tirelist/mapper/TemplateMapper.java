package org.kk.tirelist.mapper;

import org.kk.tirelist.dto.Item.ItemDto;
import org.kk.tirelist.dto.template.CreateTemplateDto;
import org.kk.tirelist.dto.template.TemplateDto;
import org.kk.tirelist.model.TemplateModel;

import java.util.List;

public class TemplateMapper {
    public static TemplateDto mapTemplateToTemplateDto(TemplateModel templateModel, List<ItemDto> itemDtos) {
        return new TemplateDto(
            templateModel.getId(),
            templateModel.getTemplateName(),
            templateModel.getDescription(),
            itemDtos
        );
    }

    public static TemplateModel mapCreatetemplateDtoToTemplate(CreateTemplateDto createTemplateDto) {
        return new TemplateModel(
            createTemplateDto.getTemplateName(),
            createTemplateDto.getDescription(),
            createTemplateDto.getItemList()
        );
    }
}
