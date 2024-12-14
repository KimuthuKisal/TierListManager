package org.kk.tirelist.mapper;

import org.kk.tirelist.dto.Category.CategoryDto;
import org.kk.tirelist.dto.Category.CreatecategoryDto;
import org.kk.tirelist.model.CategoryModel;

public class CategoryMapper {
    public static CategoryDto mapCategoryToCategoryDto(CategoryModel category) {
        return new CategoryDto(
                category.getId(),
                category.getCategoryName(),
                category.getActiveFlag()
        );
    }

    public static CategoryModel mapCreateCategoryDtoToCategory(CreatecategoryDto createcategoryDto) {
        return new CategoryModel(
                createcategoryDto.getCategoryName(),
                createcategoryDto.getActiveFlag()
        );
    }
}
