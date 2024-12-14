package org.kk.tirelist.dto.Category;

public class CategoryDto {
    private Long id;
    private String categoryName;
    private boolean activeFlag;

    public CategoryDto(Long id, String categoryName, boolean activeFlag) {
        this.id = id;
        this.categoryName = categoryName;
        this.activeFlag = activeFlag;
    }

    public Long getId() { return id; }
    public String getCategoryName() { return categoryName; }
    public boolean getActiveFlag() { return activeFlag; }
    
    public void setId(Long id) { this.id = id; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}
