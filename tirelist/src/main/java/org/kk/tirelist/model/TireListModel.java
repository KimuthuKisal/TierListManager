package org.kk.tirelist.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="tirelists")
public class TireListModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "tire_name")
    private String tireName;
    @NotBlank
    @Column(name = "description")
    private String description;
    @Column(name = "created_by", nullable = false)
    private Long createdBy;
    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;
    @Column(name = "visibility")
    private boolean visibility; // false-Private, true-Public
    @Column(name = "row_count")
    private int rowCount;
    @Column(name = "row_capacity")
    private int rowCapacity;
    @Column(name = "holder_capacity")
    private int holderCapacity;

    public TireListModel() {
    }

    public TireListModel(
            @JsonProperty("tireName") String tireName,
            @JsonProperty("description") String description,
            @JsonProperty("createdBy") Long createdBy,
            @JsonProperty("createdOn") LocalDateTime createdOn,
            @JsonProperty("visibility") boolean visibility,
            int rowCount, int rowCapacity, int holderCapacity) {
        this.tireName = tireName;
        this.description = description;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.visibility = visibility;
        this.rowCount = rowCount;
        this.rowCapacity = rowCapacity;
        this.holderCapacity = holderCapacity;
    }

    public Long getId() { return id;}
    public String getTireName() { return tireName;}
    public String getDescription() { return description;}
    public Long getCreatedBy() { return createdBy;}
    public LocalDateTime getCreatedOn() { return createdOn;}
    public LocalDateTime getUpdatedOn() { return updatedOn;}
    public boolean getVisibility() { return visibility;}
    public int getRowCount() { return rowCount; }
    public int getRowCapacity() { return rowCapacity; }
    public int getHolderCapacity() { return holderCapacity; }

    public void setId(Long id) { this.id = id;}
    public void setTireName(String tireName) { this.tireName = tireName;}
    public void setDescription(String description) { this.description = description;}
    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy;}
    public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn;}
    public void setUpdatedOn(LocalDateTime updatedOn) { this.updatedOn = updatedOn;}
    public void setVisibility(boolean visibility) { this.visibility = visibility;}
    public void setRowCount(int rowCount) { this.rowCount = rowCount; }
    public void setRowCapacity(int rowCapacity) { this.rowCapacity = rowCapacity; }
    public void setHolderCapacity(int holderCapacity) { this.holderCapacity = holderCapacity; }
}