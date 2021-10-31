package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //JPQL  @Query("select p from Product  p where p.title =:title") или
    //SQL     @Query (nativeQuery = true,value = "select * from Product p where p.title = :title") или

    List<Product> findAllByTitle(String title);

    //смотри список ключевых слов
    //список пробуктов цена которых >=  min   и  <= max
    List<Product> findAllByCostGreaterThanEqualAndCostLessThanEqual(int minCost, int maxCost);


    //то же смаое
//    List<Product> findAllByCostBetweenMinAndMax(int minCost, int maxCost);
}

