package org.kk.tirelist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tireholder")
public class TireHolderModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tire_id")
    private Long tireId;
    @Column(name = "item_id")
    private Long itemId;

    public TireHolderModel() {
    }

    public TireHolderModel(Long tireId, Long itemId) {
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
