package org.kk.tirelist.service;

import org.kk.tirelist.dto.Category.CategoryDto;
import org.kk.tirelist.dto.Category.CreateCategoryDto;
import org.kk.tirelist.dto.Item.CreateItemDto;
import org.kk.tirelist.dto.Item.ItemDto;
import org.kk.tirelist.dto.Item.UpdateItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> getAllItems();
    ItemDto getItemById(Long iid);
    List<ItemDto> findByIsActive(boolean isActive);
    List<ItemDto> findItemsByCategory(Long cid);
    ItemDto createItem(CreateItemDto createItemDto);
    ItemDto updateItem(Long iid, UpdateItemDto itemDto);
    void DeleteItem(Long iid);
    void ReActiveItem(Long iid);
}
