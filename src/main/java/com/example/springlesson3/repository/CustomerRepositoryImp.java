package com.example.springlesson3.repository;

import com.example.springlesson3.domain.Order;
import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.CustomerDAO;
import com.example.springlesson3.util.SessionFactoryBean;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImp implements CustomerDAO {

    private final SessionFactoryBean sessionFactory;


    //список заказов клиента
    @Override
    public List<Order> getOrdersByCustomerId(int customer_id) {
        List<Order> orders;
        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
            session.beginTransaction();
            orders = session.createQuery("select p from Order p where p.customerId = :pid", Order.class).setParameter("pid", customer_id).getResultList();
            session.getTransaction().commit();
        }
        return orders;
    }


    /*пока не нужен. создан для проверки*/
    @Override
    public Order get(int id) {

        Order order;
        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
            session.beginTransaction();
            order = session.get(Order.class, id);
            session.getTransaction().commit();
        }
        return order;
    }

    @Override
    public List<Product> getOrderProductsByCustomerId(int id) {
        List<Product> products;

        List<Order> orders = getOrdersByCustomerId(1);
        for (Order order : orders) {
            System.out.println(order.getId());
            getProductIDByOdderId(order.getId());
        }

        return null;
    }

    @Override
    public int getProductIDByOdderId(int id) {
        int i;
        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
            session.beginTransaction();
            //  i = session.get(Order.class, orders_products);
            session.getTransaction().commit();
        }
        return 3;
    }

}