package org.kk.tirelist.model;

import jakarta.persistence.*;

@Entity
@Table(name="tireholderitems")
public class TireHolderItemModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tire_id")
    private Long tireId;
    @Column(name = "item_id")
    private Long itemId;

    public TireHolderItemModel() {
    }

    public TireHolderItemModel(Long tireId, Long itemId) {
        this.tireId = tireId;
        this.itemId = itemId;
    }
    public Long getId() { return id; }
    public Long getTireId() { return tireId; }
    public Long getItemId() { return itemId; }
    public void setId(Long id) { this.id = id; }
    public void setTireId(Long tireId) { this.tireId = tireId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
}
