package org.kk.tirelist.service;

import org.kk.tirelist.dto.template.CreateTemplateDto;
import org.kk.tirelist.dto.template.TemplateDto;
import org.kk.tirelist.dto.template.UpdateTemplateDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TemplateService {
    List<TemplateDto> getAllTemplates();
    TemplateDto getTemplateById(Long tid);
    TemplateDto createTemplate(CreateTemplateDto createTemplateDto);
    TemplateDto updateTemplate(Long tid, UpdateTemplateDto templateDto);
    TemplateDto deleteTemplate(Long tid);
    TemplateDto addItemToTemplate(Long tid, Long iid);
    TemplateDto removeItemFromTemplate(Long tid, Long iid);

}
