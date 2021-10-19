package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    void addProduct(Product product) ;

    void addProductWithImg(Product addProduct, MultipartFile img);
}