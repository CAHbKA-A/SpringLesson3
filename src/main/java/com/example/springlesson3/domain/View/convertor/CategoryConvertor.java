package com.example.springlesson3.domain.View.convertor;

import com.example.springlesson3.domain.Category;
import com.example.springlesson3.domain.Product;
import com.example.springlesson3.domain.View.dto.CategoryDto;
import com.example.springlesson3.domain.View.dto.ProductDtoDefault;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryConvertor implements CategoryMapper{
    @Override
    public Category toCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto fromCategory(Category category) {
        return CategoryDto
                .builder()
                .id(category.getId())
                .title(category.getNameCategory())
                .build();
    }

    @Override
    public List<Category> toCategoryList(List<CategoryDto> categoryDtos) {
        return null;
    }

    @Override
    public List<CategoryDto> fromCategoryList(List<Category> categories) {
        List<CategoryDto> listDto = new ArrayList<>();
        for (Category category : categories) {
            listDto.add(fromCategory(category));

        }

        return listDto;
    }
}
