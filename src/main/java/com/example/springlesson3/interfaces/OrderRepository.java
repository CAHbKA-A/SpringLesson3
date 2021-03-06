package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Category;
import com.example.springlesson3.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

}
