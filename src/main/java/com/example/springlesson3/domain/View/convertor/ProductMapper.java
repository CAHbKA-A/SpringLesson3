package com.example.springlesson3.domain.View.convertor;


import com.example.springlesson3.domain.Product;

import com.example.springlesson3.domain.View.dto.ProductDtoDefault;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class); // создаем ссылку на mapper для получения к нему доступа в коде проекта (ProductMapper.MAPPER.toProduct(...)).

    Product toProduct(ProductDtoDefault ProductDto); // Метод toCategory будет заниматься преобразованием объекта типа ProductDto в объект типа Product, название метода не имеет значения, mapper будет смотреть на тип аргумента и тип возвращаемого значения
    @InheritInverseConfiguration

    ProductDtoDefault fromProduct(Product product); // преобразование производится в обратную сторону

    List<Product> toProductList(List<ProductDtoDefault> productDtos);

    List<ProductDtoDefault> fromProductList(List<Product> products);
}





