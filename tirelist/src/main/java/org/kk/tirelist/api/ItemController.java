package org.kk.tirelist.api;

import org.kk.tirelist.dto.Category.CategoryDto;
import org.kk.tirelist.dto.Category.CreateCategoryDto;
import org.kk.tirelist.dto.Item.CreateItemDto;
import org.kk.tirelist.dto.Item.ItemDto;
import org.kk.tirelist.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/item")
@RestController
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@Validated @NonNull @RequestBody CreateItemDto createItemDto) {
        ItemDto savedItem = itemService.createItem(createItemDto);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ItemDto>> getAllItems() {
        List<ItemDto> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
    @GetMapping("active")
    public ResponseEntity<List<ItemDto>> getAllActiveItems() {
        List<ItemDto> items = itemService.findByIsActive(true);
        return ResponseEntity.ok(items);
    }
    @GetMapping("inactive")
    public ResponseEntity<List<ItemDto>> getAllInactiveItems() {
        List<ItemDto> items = itemService.findByIsActive(false);
        return ResponseEntity.ok(items);
    }
    @GetMapping("category/{cid}")
    public ResponseEntity<List<ItemDto>> getAllItemsByCategory(@PathVariable("cid") Long cid) {
        List<ItemDto> items = itemService.findItemsByCategory(cid);
        return ResponseEntity.ok(items);
    }
    @PutMapping("{iid}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable("iid") Long iid, @RequestBody ItemDto updatedItemDto) {
        ItemDto itemDto = itemService.updateItem(iid, updatedItemDto);
        return ResponseEntity.ok(itemDto);
    }
    @PutMapping("{iid}/activate")
    public ResponseEntity<String> activateItem(@PathVariable("iid") Long iid) {
        itemService.ReActiveItem(iid);
        return ResponseEntity.ok("Item Reactivated");
    }
    @PutMapping("{iid}/deactivate")
    public ResponseEntity<String> deactivateItem(@PathVariable("iid") Long iid) {
        // TODO: Check whether the category has been referenced for items
        itemService.DeleteItem(iid);
        return ResponseEntity.ok("Item Deleted");
    }
}
