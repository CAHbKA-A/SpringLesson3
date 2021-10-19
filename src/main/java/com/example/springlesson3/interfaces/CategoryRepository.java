package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Category;
import com.example.springlesson3.domain.Product;

import java.util.List;

public interface CategoryRepository {

    Category get (Long id);

    List<Category> getAll();

    void addNew(Category category);
}
