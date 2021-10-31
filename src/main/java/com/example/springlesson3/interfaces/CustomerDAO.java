package com.example.springlesson3.interfaces;

import com.example.springlesson3.domain.Order;
import com.example.springlesson3.domain.Product;

import java.util.List;

public interface CustomerDAO {
    //список заказанных продуктов покупателем id
    public List<Product> getOrderProductsByCustomerId(int id);

    public List<Order> getOrdersByCustomerId(int customer_id);

    public Order get(int id);

    public int getProductIDByOdderId(int id);

}
