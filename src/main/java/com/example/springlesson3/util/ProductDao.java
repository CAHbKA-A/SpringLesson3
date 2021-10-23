package com.example.springlesson3.util;

import com.example.springlesson3.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public  class ProductDao {
    public static SessionFactory factory;
    private ProductDao(){};






    public static Product findById(int id){
        init();
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        // Из фабрики создаем EntityManager
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        em.getTransaction().commit();
        System.out.println(product);


        shutdown();
        return null;
    }
    private static void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    private static void shutdown() {
        factory.close();
    }
}


