package org.kk.tirelist.service;
import java.util.List;

import org.kk.tirelist.dto.Category.CategoryDto;
import org.kk.tirelist.dto.Category.CreateCategoryDto;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Long cid);
    List<CategoryDto> findCategoriesByStatus(boolean isActive);
    CategoryDto createCategory(CreateCategoryDto createcategoryDto);
    CategoryDto updateCategory(Long cid, CategoryDto categoryDto);
    void DeleteCategory(Long cid);
    void ReActiveCategory(Long cid);

}
