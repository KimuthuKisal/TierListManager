package org.kk.tirelist.service.impl;

import org.kk.tirelist.dto.Item.CreateItemDto;
import org.kk.tirelist.dto.Item.ItemDto;
import org.kk.tirelist.exception.ResourceNotFoundException;
import org.kk.tirelist.mapper.ItemMapper;
import org.kk.tirelist.model.ItemModel;
import org.kk.tirelist.repository.ItemRepository;
import org.kk.tirelist.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<ItemModel> items = itemRepository.findAll();
        return items.stream().map(ItemMapper::mapItemToItemDto).collect(Collectors.toList());
    }

    @Override
    public List<ItemDto> findByIsActive(boolean isActive) {
        List<ItemModel> itemsFilteredWithStatus = itemRepository.findByIsActive(isActive);
        return itemsFilteredWithStatus.stream().map(ItemMapper::mapItemToItemDto).collect(Collectors.toList());
    }

    @Override
    public List<ItemDto> findItemsByCategory(Long cid) {
        List<ItemModel> itemsFilteredWithCategory = itemRepository.findByCategory(cid);
        return itemsFilteredWithCategory.stream().map(ItemMapper::mapItemToItemDto).collect(Collectors.toList());
    }

    @Override
    public ItemDto createItem(CreateItemDto createItemDto) {
        ItemModel item = ItemMapper.mapCreateItemDtoToItem(createItemDto);
        ItemModel savedItem = itemRepository.save(item);
        return ItemMapper.mapItemToItemDto(savedItem);
    }

    @Override
    public ItemDto updateItem(Long iid, ItemDto itemDto) {
        ItemModel item = itemRepository.findById(iid).orElseThrow(() -> new ResourceNotFoundException("Item not found with given id " + iid));
        item.setItemName(itemDto.getItemName());
        item.setDescription(itemDto.getDescription());
        item.setImage(itemDto.getImage());
        item.setCategory(itemDto.getCategory());
        item.setTireId(itemDto.getTireId());
        item.setMetaData(itemDto.getMetaData());
        item.setIsActive(itemDto.getIsActive());
        ItemModel updatedItem = itemRepository.save(item);
        return ItemMapper.mapItemToItemDto(updatedItem);
    }

    @Override
    public void DeleteItem(Long iid) {
        ItemModel item = itemRepository.findById(iid).orElseThrow(() -> new ResourceNotFoundException("Item not found with given id " + iid));
        item.setIsActive(false);
        itemRepository.save(item);
    }

    @Override
    public void ReActiveItem(Long iid) {
        ItemModel item = itemRepository.findById(iid).orElseThrow(() -> new ResourceNotFoundException("Item not found with given id " + iid));
        item.setIsActive(true);
        itemRepository.save(item);
    }
}
