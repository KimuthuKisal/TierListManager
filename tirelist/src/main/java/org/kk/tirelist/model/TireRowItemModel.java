package org.kk.tirelist.model;

import jakarta.persistence.*;

@Entity
@Table(name="tirerowitems")
public class TireRowItemModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Column(name = "tire_id")
    // private Long tireId;
    @Column(name = "row_id")
    private Long rowId;
    @Column(name = "item_id")
    private Long itemId;

    public TireRowItemModel() {
    }

    public TireRowItemModel(Long itemId) {
        // this.tireId = tireId;
        // this.rowNumber = rowNumber;
        this.itemId = itemId;
    }
    public Long getId() { return id; }
    // public Long getTireId() { return tireId; }
    public Long getRowId() { return rowId; }
    public Long getItemId() { return itemId; }
    public void setId(Long id) { this.id = id; }
    // public void setTireId(Long tireId) { this.tireId = tireId; }
    public void setRowId(Long rowId) { this.rowId = rowId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
}
