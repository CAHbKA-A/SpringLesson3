package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Product;

import java.util.List;

public interface delete_ProductRepository {
    Product get(int id);

    List<Product> getAll();

    void addNew(Product product);


    void deleteProduct(int id);
}
