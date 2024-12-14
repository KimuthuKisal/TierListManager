package org.kk.tirelist.service.impl;

import org.kk.tirelist.dto.Category.CategoryDto;
import org.kk.tirelist.dto.Category.CreatecategoryDto;
import org.kk.tirelist.exception.ResourceNotFoundException;
import org.kk.tirelist.mapper.CategoryMapper;
import org.kk.tirelist.mapper.UserMapper;
import org.kk.tirelist.model.CategoryModel;
import org.kk.tirelist.model.UserModel;
import org.kk.tirelist.repository.CategoryRepository;
import org.kk.tirelist.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryModel> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper::mapCategoryToCategoryDto).collect(Collectors.toList());
    }

    @Override
    public List<CategoryDto> findCategoriesByStatus(boolean isActive) {
        List<CategoryModel> categoriesFilteredWithStatus = categoryRepository.findByActiveFlag(isActive);
        return categoriesFilteredWithStatus.stream().map(CategoryMapper::mapCategoryToCategoryDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto createCategory(CreatecategoryDto createcategoryDto) {
        CategoryModel category = CategoryMapper.mapCreateCategoryDtoToCategory(createcategoryDto);
        CategoryModel savedCategory = categoryRepository.save(category);
        return CategoryMapper.mapCategoryToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto updateCategory(Long cid, CategoryDto categoryDto) {
        CategoryModel category = categoryRepository.findById(cid).orElseThrow( ()-> new ResourceNotFoundException("Category not found with given id " + cid));
        category.setCategoryName(categoryDto.getCategoryName());
        CategoryModel updatedCategory = categoryRepository.save(category);
        return CategoryMapper.mapCategoryToCategoryDto(updatedCategory);
    }

    @Override
    public void DeleteCategory(Long cid) {
        CategoryModel category = categoryRepository.findById(cid).orElseThrow( ()-> new ResourceNotFoundException("Category not found with given id " + cid));
        category.setActiveFlag(false);
        categoryRepository.save(category);
    }

    @Override
    public void ReActiveCategory(Long cid) {
        CategoryModel category = categoryRepository.findById(cid).orElseThrow( ()-> new ResourceNotFoundException("Category not found with given id " + cid));
        category.setActiveFlag(true);
        categoryRepository.save(category);
    }
}
