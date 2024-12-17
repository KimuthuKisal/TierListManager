package org.kk.tirelist.mapper;

import org.kk.tirelist.dto.Item.CreateItemDto;
import org.kk.tirelist.dto.Item.ItemDto;
import org.kk.tirelist.model.ItemModel;

public class ItemMapper {
    public static ItemDto mapItemToItemDto(ItemModel item) {
        return new ItemDto(
                item.getId(),
                item.getItemName(),
                item.getDescription(),
                item.getImage(),
                item.getCategory(),
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
