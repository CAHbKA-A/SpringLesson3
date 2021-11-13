package com.example.springlesson3.domain.View.convertor;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.domain.View.dto.ProductDtoDefault;

import java.util.ArrayList;
import java.util.List;


public class ProductConvertor implements ProductMapper {
    @Override
    public Product toProduct(ProductDtoDefault ProductDto) {
        return null;
    }

    @Override
    public ProductDtoDefault fromProduct(Product product) {

        return ProductDtoDefault
                .builder()
                .id(product.getId())
                .title(product.getTitle())
                .cost(product.getCost())
                //  .categories(CategoryConvertor.fromCategory(product.getCategories()))
                .build();
    }

    @Override
    public List<Product> toProductList(List<ProductDtoDefault> productDtos) {
        return null;
    }

    @Override
    public List<ProductDtoDefault> fromProductList(List<Product> products) {
        List<ProductDtoDefault> listDto = new ArrayList<>();
        for (Product product : products) {
            listDto.add(fromProduct(product));

        }

        return listDto;
    }

}
