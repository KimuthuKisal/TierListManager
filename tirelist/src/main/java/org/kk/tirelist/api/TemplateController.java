package org.kk.tirelist.api;

import org.kk.tirelist.dto.Item.ItemDto;
import org.kk.tirelist.dto.template.CreateTemplateDto;
import org.kk.tirelist.dto.template.TemplateDto;
import org.kk.tirelist.dto.template.UpdateTemplateDto;
import org.kk.tirelist.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/template")
@RestController
public class TemplateController {
    public final TemplateService templateService;

    @Autowired
    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @PostMapping
    public ResponseEntity<TemplateDto> createTemplate(@Validated @NonNull @RequestBody CreateTemplateDto createTemplateDto) {
        TemplateDto savedTemplate = templateService.createTemplate(createTemplateDto);
        return new ResponseEntity<>(savedTemplate, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<TemplateDto>> getAllTemplates() {
        List<TemplateDto> templates = templateService.getAllTemplates();
        return ResponseEntity.ok(templates);
    }
    @GetMapping("{tid}")
    public ResponseEntity<TemplateDto> getTemplateById(@PathVariable("tid") Long tid) {
        TemplateDto template = templateService.getTemplateById(tid);
        return ResponseEntity.ok(template);
    }
    @PutMapping("{tid}")
    public ResponseEntity<TemplateDto> updateTemplateById(@PathVariable("tid") Long tid, @RequestBody UpdateTemplateDto updateTemplateDto) {
        TemplateDto updatedTemplate = templateService.updateTemplate(tid, updateTemplateDto);
        return ResponseEntity.ok(updatedTemplate);
    }
    @DeleteMapping("{tid}")
    public ResponseEntity<TemplateDto> deleteTemplate(@PathVariable("tid") Long tid) {
        TemplateDto deletedtemplate = templateService.deleteTemplate(tid);
        return ResponseEntity.ok(deletedtemplate);
    }
    @PutMapping("add/{tid}/{iid}")
    public ResponseEntity<TemplateDto> addItemToTemplate(@PathVariable("tid") Long tid, @PathVariable("iid") Long iid) {
        TemplateDto itemAddedTemplate = templateService.addItemToTemplate(tid, iid);
        return ResponseEntity.ok(itemAddedTemplate);
    }
    @PutMapping("remove/{tid}/{iid}")
    public ResponseEntity<TemplateDto> removeItemFromTemplate(@PathVariable("tid") Long tid, @PathVariable("iid") Long iid) {
        TemplateDto itemRemovedTemplate = templateService.removeItemFromTemplate(tid, iid);
        return ResponseEntity.ok(itemRemovedTemplate);
    }
}
