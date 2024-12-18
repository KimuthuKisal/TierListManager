package org.kk.tirelist.dto.tire;

public class TireRowItemDto {
    private Long id;
    private Long rowId;
    private Long itemId;

    public TireRowItemDto() {
    }

    public TireRowItemDto(Long id, Long rowId, Long itemId) {
        this.id = id;
        this.rowId = rowId;
        this.itemId = itemId;
    }

    public Long getId() { return id; }
    public Long getItemId() { return itemId; }
    public Long getRowId() { return rowId; }

    public void setId(Long id) { this.id = id; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
    public void setRowId(Long rowId) { this.rowId = rowId; }
}
