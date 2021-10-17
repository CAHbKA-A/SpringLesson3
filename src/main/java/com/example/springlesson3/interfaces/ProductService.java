package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    void addProduct(Product product) ;

}