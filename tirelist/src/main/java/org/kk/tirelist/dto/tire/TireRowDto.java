package org.kk.tirelist.dto.tire;

import java.util.List;

public class TireRowDto {
    private Long id;
    private Long tireId;
    private int rowNumber;
    private int position;
    private List<TireRowItemDto> items;

    public TireRowDto() {
    }

    public TireRowDto(Long id, Long tireId, int rowNumber, int position, List<TireRowItemDto> items) {
        this.id = id;
        this.tireId = tireId;
        this.rowNumber = rowNumber;
        this.position = position;
        this.items = items;
    }

    public Long getId() { return id; }
    public Long getTireId() { return tireId; }
    public int getRowNumber() { return rowNumber; }
    public int getPosition() { return position; }
    public List<TireRowItemDto> getItems() { return items; }

    public void setId(Long id) { this.id = id; }
    public void setTireId(Long tireId) { this.tireId = tireId; }
    public void setRowNumber(int rowNumber) { this.rowNumber = rowNumber; }
    public void setPosition(int position) { this.position = position; }
    public void setItems(List<TireRowItemDto> items) { this.items = items; }
}
