package com.example.springlesson3.repository;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.CategoryRepository;
import com.example.springlesson3.interfaces.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImp implements ProductRepository {
 private  final CategoryRepository categoryRepository;

    @Override
    public Product get(int id) {

        /*тут будет запрос к бд. пока генерим список налету*/
        return Product.builder()
                .id(id)
                .title("Pr" + id)
                .description("blahblah")
                .cost((int) (123 * id))
                .categoryId(categoryRepository.get(id))
                .build();
    }

    @Override
    public List<Product> getAll() {
        /*тут будет запрос к бд*/
        ArrayList<Product> list = new ArrayList<Product>();
        for (int i = 0; i < 10; i++) {
            list.add(get( i));

        }


        return list;
    }

    @Override
    public void addNew(Product product) {
        /*тут будет add запрос к бд*/

        getAll().add(product);
    }
}