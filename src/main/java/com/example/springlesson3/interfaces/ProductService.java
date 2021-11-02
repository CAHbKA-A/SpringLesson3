package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    Page<Product> getProducts();

    public Page<Product> SearchProducts();

    void addProductWithImg(Product addProduct, MultipartFile img);

    Product getProductById(int id);

    void deleteProduct(int id);

    Product editProduct(Product product);

    Page<Product> findAllByCostLessThanEqualAndCostGreaterThanEqual(Integer minCost, Integer maxCost, Pageable pageable);


}