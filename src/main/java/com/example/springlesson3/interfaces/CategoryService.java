package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Category;
import com.example.springlesson3.domain.CategoryTree;
import com.example.springlesson3.domain.Product;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    CategoryTree getCategoryTree();


    List<Product> findByPathUrl(String category_uRl);
}
