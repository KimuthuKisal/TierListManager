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
    private int visibility; // 0-Private, 1-Public

    public TireListModel() {
    }

    public TireListModel(
        @JsonProperty("tireName") String tireName, 
        @JsonProperty("description") String description, 
        @JsonProperty("createdBy") Long createdBy, 
        @JsonProperty("createdOn") LocalDateTime createdOn,
        @JsonProperty("visibility") int visibility
    ) {
        this.tireName = tireName;
        this.description = description;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.visibility = visibility;
    }

    public Long getId() { return id;}
    public String getTireName() { return tireName;}
    public String getDescription() { return description;}
    public Long getCreatedBy() { return createdBy;}
    public LocalDateTime getCreatedOn() { return createdOn;}
    public LocalDateTime getUpdatedOn() { return updatedOn;}
    public int getVisibility() { return visibility;}

    public void setId(Long id) { this.id = id;}
    public void setTireName(String tireName) { this.tireName = tireName;}
    public void setDescription(String description) { this.description = description;}
    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy;}
    public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn;}
    public void setUpdatedOn(LocalDateTime updatedOn) { this.updatedOn = updatedOn;}
    public void setVisibility(int visibility) { this.visibility = visibility;}
}