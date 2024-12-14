package org.kk.tirelist.service;
import java.util.List;

import org.kk.tirelist.dto.Category.CategoryDto;
import org.kk.tirelist.dto.Category.CreatecategoryDto;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    List<CategoryDto> findCategoriesByStatus(boolean isActive);
    CategoryDto createCategory(CreatecategoryDto createcategoryDto);
    CategoryDto updateCategory(Long cid, CategoryDto categoryDto);
    void DeleteCategory(Long cid);
    void ReActiveCategory(Long cid);

}
