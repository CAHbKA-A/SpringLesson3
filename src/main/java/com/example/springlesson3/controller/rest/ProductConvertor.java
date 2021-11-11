package com.example.springlesson3.controller.rest;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.domain.View.convertor.ProductMapper;
import com.example.springlesson3.domain.View.dto.ProductDtoDefault;
import com.example.springlesson3.interfaces.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductConvertor {
    private final ProductRepository productRepository;

    public ProductDtoDefault save(ProductDtoDefault itemDto) {
        Product product = ProductMapper.MAPPER.toProduct(itemDto);
        product = productRepository.save(product);
        return ProductMapper.MAPPER.fromProduct(product);
    }

    public List<ProductDtoDefault> findAll() {
        return ProductMapper.MAPPER.fromProductList(productRepository.findAll());
        //    return ProductMapper.MAPPER.fromProductList(productRepository.findAllItemsWithCategories());
    }

    public ProductDtoDefault findOne(Long id) {
        return ProductMapper.MAPPER.fromProduct(productRepository.findById(id).get());
    }

}
