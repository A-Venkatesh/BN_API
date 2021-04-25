package com.konda.baskinnature.service.implementations;

import com.konda.baskinnature.model.Category;
import com.konda.baskinnature.model.Product;
import com.konda.baskinnature.repository.CategoryRepository;
import com.konda.baskinnature.repository.ProductRepository;
import com.konda.baskinnature.service.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepostory;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.insert(category);

    }

    @Override
    public Category updateCategory(Category category, String id) {

        Category oldCategory = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Category with provided ID : %s", id)));
        oldCategory.setName(category.getName());
        List<Product> products = productRepostory.findAllByCategoryId(id);
        for (Product prod : products) {
            prod.setGenre(category.getName());
            productRepostory.save(prod);
        }
        return categoryRepository.save(oldCategory);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(String id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Category with provided ID : %s", id)));
    }

    @Override
    public String deleteCategory(String id) {
        categoryRepository.deleteById(id);
        return " Category with id " + id + " has been deleted successfully";
    }
}
