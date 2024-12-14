package org.kk.tirelist.api;

import org.kk.tirelist.dto.Category.CategoryDto;
import org.kk.tirelist.dto.Category.CreatecategoryDto;
import org.kk.tirelist.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Validated @NonNull @RequestBody CreatecategoryDto createcategoryDto) {
        CategoryDto savedCategory = categoryService.createCategory(createcategoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("active")
    public ResponseEntity<List<CategoryDto>> getAllActiveCategories() {
        List<CategoryDto> categories = categoryService.findCategoriesByStatus(true);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("inactive")
    public ResponseEntity<List<CategoryDto>> getAllInactiveCategories() {
        List<CategoryDto> categories = categoryService.findCategoriesByStatus(false);
        return ResponseEntity.ok(categories);
    }

    @PutMapping("{cid}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("cid") Long cid, @RequestBody CategoryDto updatedCategoryDto) {
        CategoryDto categoryDto = categoryService.updateCategory(cid, updatedCategoryDto);
        return ResponseEntity.ok(categoryDto);
    }

    @PutMapping("{cid}/activate")
    public ResponseEntity<String> activateCategory(@PathVariable("cid") Long cid) {
        categoryService.ReActiveCategory(cid);
        return ResponseEntity.ok("Category Reactivated");
    }

    @PutMapping("{cid}/deactivate")
    public ResponseEntity<String> deactivateCategory(@PathVariable("cid") Long cid) {
        categoryService.DeleteCategory(cid);
        return ResponseEntity.ok("Category Deleted");
    }
}
