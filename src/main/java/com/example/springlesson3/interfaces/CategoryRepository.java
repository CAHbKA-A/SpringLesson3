package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Category;
import com.example.springlesson3.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Set<Category> findAllByParentCategoryIsNull();

   // Set<Category> findAllByparentCategoryIsNull();
   // List<Product> findAllByIdEquals (String cat);


 //   List<Product> findProductsByByCategoriesEquals(Integer cat);
}
