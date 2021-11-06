package com.example.springlesson3.controller.rest;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor

public class ProductResController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//вертает стсус_"создано"
    public void saveProduct(@RequestBody Product product){
        productService.addProductWithImg(product,null);
    }
}
