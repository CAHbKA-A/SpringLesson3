package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    Page<Product> getProducts();

  //  void addProduct(Product product);

    void addProductWithImg(Product addProduct, MultipartFile img);

    Product getProductById(int id);

    void deleteProduct(int id);

    Product editProduct(Product product);
}