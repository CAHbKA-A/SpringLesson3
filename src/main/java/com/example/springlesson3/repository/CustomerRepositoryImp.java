package com.example.springlesson3.repository;

import com.example.springlesson3.domain.Order;
import com.example.springlesson3.domain.Product;
import com.example.springlesson3.interfaces.CategoryDAO;
import com.example.springlesson3.interfaces.CustomerDAO;
import com.example.springlesson3.interfaces.ProductDAO;
import com.example.springlesson3.util.SessionFactoryBean;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImp implements CustomerDAO {

   private final SessionFactoryBean sessionFactory;


    //список заказанных продуктов покупателем id
    @Override
    public List<Product> getOrderProducts(int id) {

        List<Product> products;
        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
            session.beginTransaction();
         //   products = session.createQuery("select p from Product p  where :p.id_products = :pid ", Product.class).setParameter("pid", id).getResultList();
            session.getTransaction().commit();
        }

        return null;
    }

    //список заказов клиента
    @Override
    public List<Order> getOrders(int customer_id){
        List<Order> orders;
        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
            session.beginTransaction();
            //   orders = session.createQuery("select p from Order p  where p.id = :pid ", Order.class).setParameter("pid", customer_id).getResultList();
            orders = session.createQuery("select p from Order p", Order.class).getResultList();
            session.getTransaction().commit();
        }
        return orders;

    }
//    @Override
//    public Order get(int id) {
//
//        Order product;
//        try (Session session = sessionFactory.getFactoryBean().getCurrentSession()) {
//            session.beginTransaction();
//            product = session.get(Order.class, id);
//            session.getTransaction().commit();
//        }
//        return product;
//    }
}