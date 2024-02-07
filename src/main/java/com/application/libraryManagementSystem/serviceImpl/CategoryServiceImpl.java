package com.application.libraryManagementSystem.serviceImpl;

import com.application.libraryManagementSystem.entity.Category;
import com.application.libraryManagementSystem.repository.CategoryRepository;
import com.application.libraryManagementSystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
    @Override
    public Category findCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()->new RuntimeException(String.format("Category of Id : %d Not found",categoryId)));
        return category;
    }
    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }
    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()->new RuntimeException(String.format("Category of Id : %d Not found",categoryId)));
        categoryRepository.deleteById(category.getId());
    }
}
