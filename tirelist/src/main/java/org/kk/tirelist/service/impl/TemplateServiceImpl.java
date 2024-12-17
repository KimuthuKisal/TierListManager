package org.kk.tirelist.service.impl;

import org.kk.tirelist.dto.Item.ItemDto;
import org.kk.tirelist.dto.template.CreateTemplateDto;
import org.kk.tirelist.dto.template.TemplateDto;
import org.kk.tirelist.dto.template.UpdateTemplateDto;
import org.kk.tirelist.exception.ResourceNotFoundException;
import org.kk.tirelist.mapper.ItemMapper;
import org.kk.tirelist.mapper.TemplateMapper;
import org.kk.tirelist.model.ItemModel;
import org.kk.tirelist.model.TemplateModel;
import org.kk.tirelist.repository.ItemRepository;
import org.kk.tirelist.repository.TemplateRepository;
import org.kk.tirelist.service.TemplateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TemplateServiceImpl implements TemplateService {
    private TemplateRepository templateRepository;
    private ItemRepository itemRepository;

    public TemplateServiceImpl(TemplateRepository templateRepository, ItemRepository itemRepository) {
        this.templateRepository = templateRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public List<TemplateDto> getAllTemplates() {
        List<TemplateModel> templates = templateRepository.findAll();
        Set<Long> allItemIds = new HashSet<>();

        for (TemplateModel template : templates) {
            if (template.getItemList() != null) { // Check for null itemList
                allItemIds.addAll(template.getItemList());
            }
        }

        List<ItemModel> items = itemRepository.findAllById(new ArrayList<>(allItemIds));
        List<ItemDto> itemDtos = items.stream()
                .map(ItemMapper::mapItemToItemDto)
                .toList();

        List<TemplateDto> templateDtos = templates.stream()
                .map(template -> {
                    List<ItemDto> templateItemDtos = itemDtos.stream()
                            .filter(itemDto -> template.getItemList() != null &&
                                    template.getItemList().contains(itemDto.getId()))
                            .collect(Collectors.toList());
                    return TemplateMapper.mapTemplateToTemplateDto(template, templateItemDtos);
                })
                .collect(Collectors.toList());

        return templateDtos;
    }

    @Override
    public TemplateDto getTemplateById(Long tid) {
        TemplateModel template = templateRepository.findById(tid).orElseThrow( ()-> new ResourceNotFoundException("Template not found with given id " + tid));
        List<Long> templateItems = template.getItemList();
        List<ItemModel> items = itemRepository.findAllById(templateItems);
        List<ItemDto> itemDtos = items.stream().map(ItemMapper::mapItemToItemDto).collect(Collectors.toList());
        return TemplateMapper.mapTemplateToTemplateDto(template, itemDtos);
    }

    @Override
    public TemplateDto createTemplate(CreateTemplateDto createTemplateDto) {
        TemplateModel template = TemplateMapper.mapCreatetemplateDtoToTemplate(createTemplateDto);
        TemplateModel savedTemplate = templateRepository.save(template);
        List<Long> templateItems = savedTemplate.getItemList();
        List<ItemModel> items = itemRepository.findAllById(templateItems);
        List<ItemDto> itemDtos = items.stream().map(ItemMapper::mapItemToItemDto).toList();
        return TemplateMapper.mapTemplateToTemplateDto(savedTemplate, itemDtos);
    }

    @Override
    public TemplateDto updateTemplate(Long tid, UpdateTemplateDto templateDto) {
        TemplateModel template = templateRepository.findById(tid).orElseThrow( ()-> new ResourceNotFoundException("Template not found with given id " + tid));
        template.setTemplateName(templateDto.getTemplateName());
        template.setDescription(templateDto.getDescription());
        TemplateModel updatedTemplate = templateRepository.save(template);
        List<Long> templateItems = template.getItemList();
        List<ItemModel> items = itemRepository.findAllById(templateItems);
        List<ItemDto> itemDtos = items.stream().map(ItemMapper::mapItemToItemDto).toList();
        return TemplateMapper.mapTemplateToTemplateDto(updatedTemplate, itemDtos);
    }

    @Override
    public TemplateDto deleteTemplate(Long tid) {
        TemplateModel template = templateRepository.findById(tid).orElseThrow( ()-> new ResourceNotFoundException("Template not found with given id " + tid));
        templateRepository.delete(template);
        return TemplateMapper.mapTemplateToTemplateDto(template, null);
    }

    @Override
    public TemplateDto addItemToTemplate(Long tid, Long iid) {
        TemplateModel template = templateRepository.findById(tid).orElseThrow( ()-> new ResourceNotFoundException("Template not found with given id " + tid));
        template.addItem(iid);
        templateRepository.save(template);
        List<Long> templateItems = template.getItemList();
        List<ItemModel> items = itemRepository.findAllById(templateItems);
        List<ItemDto> itemDtos = items.stream().map(ItemMapper::mapItemToItemDto).collect(Collectors.toList());
        return TemplateMapper.mapTemplateToTemplateDto(template, itemDtos);
    }

    @Override
    public TemplateDto removeItemFromTemplate(Long tid, Long iid) {
        TemplateModel template = templateRepository.findById(tid).orElseThrow( ()-> new ResourceNotFoundException("Template not found with given id " + tid));
        template.removeItem(iid);
        templateRepository.save(template);
        List<Long> templateItems = template.getItemList();
        List<ItemModel> items = itemRepository.findAllById(templateItems);
        List<ItemDto> itemDtos = items.stream().map(ItemMapper::mapItemToItemDto).collect(Collectors.toList());
        return TemplateMapper.mapTemplateToTemplateDto(template, itemDtos);
    }
}
