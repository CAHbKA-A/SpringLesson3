package com.example.springlesson3.repository;

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.CategoryDAO;
import com.example.springlesson3.interfaces.OrderDAO;
import com.example.springlesson3.util.SessionFactoryBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImp implements OrderDAO {
    private final CategoryDAO categoryDAO;
    private final SessionFactoryBean sessionFactory;


    //список заказанных продуктов покупателем id
    @Override
    public List<Product> getOrderProductsByCustomerId(int customer_id) {
        List<Product> products;
//        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
//            session.beginTransaction();
//            products = session.createQuery("select p from Product p where p.product_id = :pid", Order.class).setParameter("pid", customer_id).getResultList();
//            session.getTransaction().commit();
//        }
//        return products;
        return null;
    }


}