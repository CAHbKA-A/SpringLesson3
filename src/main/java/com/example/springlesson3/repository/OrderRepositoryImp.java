package com.example.springlesson3.repository;

import com.example.springlesson3.domain.Customer;
import com.example.springlesson3.domain.Order;
import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.CategoryDAO;
import com.example.springlesson3.interfaces.CustomerDAO;
import com.example.springlesson3.interfaces.OrderDAO;
import com.example.springlesson3.util.SessionFactoryBean;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImp implements OrderDAO {
    private final CategoryDAO categoryDAO;
    private final SessionFactoryBean sessionFactory;


    //список заказанных продуктов покупателем id
    @Override
    public List<Customer> getProductsBayer(int id) {

        List<Customer> products;
        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
            session.beginTransaction();
          //  products = session.createQuery("select p from Product p", Product.class).getResultList();
            session.getTransaction().commit();
        }

        return null;
    }

    @Override
    public List<Order> getOrders(int customer_id) {
        return null;
    }


}