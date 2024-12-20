package org.kk.tirelist.dto.tire;

import org.kk.tirelist.dto.Item.ItemDto;
import org.kk.tirelist.model.ItemModel;

public class TireHolderDto {
    private Long id;
    private Long tireId;
    private ItemDto item;

    public TireHolderDto() {
    }

    public TireHolderDto(Long id, Long tireId, ItemDto item) {
        this.id = id;
        this.tireId = tireId;
        this.item = item;
    }
    public Long getId() { return id; }
    public ItemDto getItemId() { return item; }
    public Long getTireId() { return tireId; }

    public void setId(Long id) { this.id = id; }
    public void setItemId(ItemDto item) { this.item = item; }
    public void setTireId(Long tireId) { this.tireId = tireId; }
}
