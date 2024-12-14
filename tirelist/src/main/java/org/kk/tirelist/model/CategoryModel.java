package org.kk.tirelist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
public class CategoryModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "category_name")
    private String categoryName;

    public CategoryModel() {
    }

    public CategoryModel(@JsonProperty("categoryName") String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getId() { return id; }
    public String getCategoryName() { return categoryName; }
    
    public void setId(Long id) { this.id = id; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}
