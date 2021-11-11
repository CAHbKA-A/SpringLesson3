package com.example.springlesson3.domain.View.convertor;

import com.example.springlesson3.domain.Category;
import com.example.springlesson3.domain.View.dto.CategoryDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class); // создаем ссылку на mapper для получения к нему доступа в коде проекта (CategoryMapper.MAPPER.toCategory(...)).

    Category toCategory(CategoryDto categoryDto); // Метод toCategory будет заниматься преобразованием объекта типа CategoryDto в объект типа Category, название метода не имеет значения, mapper будет смотреть на тип аргумента и тип возвращаемого значения

    @InheritInverseConfiguration
    CategoryDto fromCategory(Category category); // преобразование производится в обратную сторону

    List<Category> toCategoryList(List<CategoryDto> categoryDtos);

    List<CategoryDto> fromCategoryList(List<Category> categories);
}

