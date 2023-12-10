package com.rs.hospital.dto;

import com.rs.hospital.model.Category;

import java.time.LocalDateTime;

public class CategoryDTO {

    protected Long id;
    private String categoryName;
    private Long createdBy;
    private LocalDateTime createdDate;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category) {

        this.id = category.getId();
        this.categoryName = category.getCategoryName();
        this.createdBy = category.getCreatedBy();
        this.createdDate  = category.getCreatedDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
