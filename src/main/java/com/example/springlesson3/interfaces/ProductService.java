package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.domain.ProductSearch;
import com.example.springlesson3.domain.View.dto.ProductDtoDefault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<ProductDtoDefault> getProducts();

    ProductDtoDefault addProductWithImg(ProductDtoDefault addProduct, MultipartFile img);

    ProductDtoDefault findByIdDto(long id);
//    Product getProductById(Long id);
//
//    void deleteProduct(Long id);
//
//    Product editProduct(Product product);
//
//    Page<Product> findAllByCostLessThanEqualAndCostGreaterThanEqual(Integer minCost, Integer maxCost, Pageable pageable);
//
//    List<Product> findAllByCategories_Alias(String alias);
//
//    Object getProductsByConditional(ProductSearch conditional);

}