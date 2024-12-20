package org.kk.tirelist.dto.tire;

import org.kk.tirelist.dto.Item.ItemDto;

public class TireRowItemDto {
    private Long id;
    private Long rowId;
    private ItemDto item;

    public TireRowItemDto() {
    }

    public TireRowItemDto(Long id, Long rowId, ItemDto item) {
        this.id = id;
        this.rowId = rowId;
        this.item = item;
    }

    public Long getId() { return id; }
    public ItemDto getItem() { return item; }
    public Long getRowId() { return rowId; }

    public void setId(Long id) { this.id = id; }
    public void setItem(ItemDto item) { this.item = item; }
    public void setRowId(Long rowId) { this.rowId = rowId; }
}
