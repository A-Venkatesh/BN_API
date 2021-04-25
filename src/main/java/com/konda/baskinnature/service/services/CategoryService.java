package com.konda.baskinnature.service.services;

import com.konda.baskinnature.model.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);

    Category updateCategory(Category category, String id);

    List<Category> getCategories();

    Category getCategory(String id);

    String deleteCategory(String id);
}
