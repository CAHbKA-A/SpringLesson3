package com.example.springlesson3.util;

import com.example.springlesson3.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDao {

    public static SessionFactory factory;
    public static EntityManager em;



    public static Product findById(int id) {
        init();

        em = factory.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        em.getTransaction().commit();
        shutdown();
        return product;
    }

    public static List<Product> findAll() {
        init();
        List<Product> products;
        em = factory.createEntityManager();
        em.getTransaction().begin();
        products = em.createQuery("select p from Product p", Product.class).getResultList();
        em.getTransaction().commit();
        shutdown();
        return products;
    }

    /*не пашет*/
    public static void deleteById(Product product) {

        init();
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
        shutdown();

    }




//    public static void deleteById(int id) {
//        init();
//
//        em = factory.createEntityManager();
//        em.getTransaction().begin();
//        products = em.createQuery("delete d from Product p", Product.class).getResultList();
//        em.getTransaction().commit();
//        shutdown();
//        return products;
//    }

// public static Product saveOrUpdate(Product product){
//     Product newProduct;
//
//
//        return newProduct;
// }
    private static void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    private static void shutdown() {
        factory.close();
    }
}


