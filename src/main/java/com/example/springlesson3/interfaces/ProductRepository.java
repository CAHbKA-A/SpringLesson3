package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Product;

import java.util.List;

public interface ProductRepository {
    Product get(Long id);

    List<Product> getAll();
}
