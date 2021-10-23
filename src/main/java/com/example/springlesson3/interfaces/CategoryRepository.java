package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Category;

import java.util.List;

public interface CategoryRepository {

    Category get (int id);

    List<Category> getAll();

    void addNew(Category category);
}
