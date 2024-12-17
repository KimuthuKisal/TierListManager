package org.kk.tirelist.model;

import jakarta.persistence.*;

@Entity
@Table(name="tirerows")
public class TireRowModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tire_id")
    private Long tireId;
    @Column(name = "row_number")
    private Long rowNumber;

    public TireRowModel() {
    }

    public TireRowModel(Long id, Long tireId, Long rowNumber) {
        this.id = id;
        this.tireId = tireId;
        this.rowNumber = rowNumber;
    }
    public Long getId() { return id; }
    public Long getTireId() { return tireId; }
    public Long getRowNumber() { return rowNumber; }
    public void setId(Long id) { this.id = id; }
    public void setTireId(Long tireId) { this.tireId = tireId; }
    public void setRowNumber(Long rowNumber) { this.rowNumber = rowNumber; }
}
