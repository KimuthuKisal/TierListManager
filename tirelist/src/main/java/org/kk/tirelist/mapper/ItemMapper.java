package org.kk.tirelist.mapper;

import org.kk.tirelist.dto.Category.CategoryDto;
import org.kk.tirelist.dto.Item.CreateItemDto;
import org.kk.tirelist.dto.Item.ItemDto;
import org.kk.tirelist.model.CategoryModel;
import org.kk.tirelist.model.ItemModel;
import org.kk.tirelist.service.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    private final CategoryService categoryService;
    public ItemMapper(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    public CategoryDto getCategoryDto(Long cid) {
        return categoryService.getCategoryById(cid);
    }

    public ItemDto mapItemToItemDto(ItemModel item) {
        Long categoryId = item.getCategory();
        CategoryDto categoryDto = getCategoryDto(categoryId);
        return new ItemDto(
                item.getId(),
                item.getItemName(),
                item.getDescription(),
                item.getImage(),
                categoryDto,
                // item.getTireId(),
                item.getMetaData(),
                item.getIsActive()
        );
    }

    public static ItemModel mapCreateItemDtoToItem(CreateItemDto createItemDto) {
        return new ItemModel(
                createItemDto.getItemName(),
                createItemDto.getDescription(),
                createItemDto.getImage(),
                createItemDto.getCategory(),
                // createItemDto.getTireId(),
                createItemDto.getMetaData(),
                createItemDto.getIsActive());
    }
}


