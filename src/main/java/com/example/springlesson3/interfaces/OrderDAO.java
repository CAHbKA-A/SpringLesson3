package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Customer;
import com.example.springlesson3.domain.Order;
import com.example.springlesson3.domain.Product;

import java.util.List;

public interface OrderDAO {
    //список покупетелей продукта id
    public List<Customer> getProductsBayer(int id);
    public List<Order> getOrders(int customer_id);
}
