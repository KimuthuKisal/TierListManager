package org.kk.tirelist.dto.Category;

public class CreateCategoryDto {
    private String categoryName;
    private boolean activeFlag;
    public CreateCategoryDto(String categoryName, boolean activeFlag) {
        this.categoryName = categoryName;
        this.activeFlag = activeFlag;
    }

    public String getCategoryName() { return categoryName; }
    public boolean getActiveFlag() { return activeFlag; }
    
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public void setActiveFlag(boolean activeFlag) { this.activeFlag = activeFlag; }
}
