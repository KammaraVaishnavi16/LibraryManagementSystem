package com.application.libraryManagementSystem.service;

import com.application.libraryManagementSystem.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAllCategories();
    public Category findCategoryById(Long categoryId);

    public void createCategory(Category category);

    public void deleteCategory(Long id);
}
