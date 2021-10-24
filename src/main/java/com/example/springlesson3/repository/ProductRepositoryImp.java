package com.example.springlesson3.repository;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.CategoryRepository;
import com.example.springlesson3.interfaces.ProductRepository;
import com.example.springlesson3.util.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImp implements ProductRepository {
    private final CategoryRepository categoryRepository;

    @Override
    public Product get(int id) {
        return ProductDao.findById(id);
    }

    @Override
    public List<Product> getAll() {
        return ProductDao.findAll();
    }

    @Override
    public void addNew(Product product) {
        ProductDao.addProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        ProductDao.deleteById(id);

    }
}