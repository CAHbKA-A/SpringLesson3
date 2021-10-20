package com.example.springlesson3.repository;

import com.example.springlesson3.domain.Category;
import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImp implements CategoryRepository {
    @Override
    public Category get(int id) {

        /*тут будет запрос к бд. пока генерим список налету*/
        return Category.builder()
                .id(id)
                .nameCategory("Category N" + id)
                .pathUrl("/Category_" + id)
                .build();
    }

    @Override
    public List<Category> getAll() {
        /*тут будет запрос к бд*/
        ArrayList<Category> list = new ArrayList<Category>();
        for (int i = 0; i < 10; i++) {
            list.add(get( i));

        }


        return list;
    }

    @Override
    public void addNew(Category category) {
        /*тут будет add запрос к бд*/

        getAll().add(category);
    }
}