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
    private int rowNumber;
    @Column(name = "position")
    private int position;

    public TireRowModel() {
    }
    public TireRowModel(Long tireId, int rowNumber, int position) {
        this.tireId = tireId;
        this.rowNumber = rowNumber;
        this.position = position;
    }
//    public TireRowModel(Long id, Long tireId, int rowNumber, int position) {
//        this.id = id;
//        this.tireId = tireId;
//        this.rowNumber = rowNumber;
//        this.position = position;
//    }
    public Long getId() { return id; }
    public Long getTireId() { return tireId; }
    public int getRowNumber() { return rowNumber; }
    public int getPosition() { return position; }

    public void setId(Long id) { this.id = id; }
    public void setTireId(Long tireId) { this.tireId = tireId; }
    public void setRowNumber(int rowNumber) { this.rowNumber = rowNumber; }
    public void setPosition(int position) { this.position = position; }
}
