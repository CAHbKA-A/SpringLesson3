package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findAllByTitle(String title);

    List<Product> findAllByCostGreaterThanEqualAndCostLessThanEqual(int minCost, int maxCost);

    Page<Product> findAllByCostLessThanEqualAndCostGreaterThanEqual(Integer maxPrice, Integer minPrice, Pageable pageable);



    List<Product> findAllByCategories_PathUrl(String alias);
}

