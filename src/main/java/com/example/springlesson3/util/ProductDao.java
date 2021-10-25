package com.example.springlesson3.util;

import com.example.springlesson3.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDao {

    public static SessionFactory factory;
    public static EntityManager em;
//    ProductDao(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(SessionFactoryBean.class);
//        factory = context.getBean(SessionFactory.class);
//    }


    public static Product findById(int id) {
        init();


        // em.getTransaction().begin();
        Product product = em.find(Product.class, id);

        shutdown();
        return product;
    }

    public static List<Product> findAll() {
        init();
        List<Product> products;
        products = em.createQuery("select p from Product p", Product.class).getResultList();
        shutdown();
        return products;
    }


    public static void deleteById(int id) {
        Product product = ProductDao.findById(id);
        init();
        em.remove(product);
        shutdown();

    }


    //Product saveOrUpdate(Product product))

    public static void SaveOrUpdate(Product product, int id) {
        Session sessionOne = factory.getSessionFactory().openSession();
        sessionOne.beginTransaction();
        sessionOne.saveOrUpdate(product);


//        init();
//       em.persist(product);

//       em.getTransaction().commit();
////  Product productFromDB = ProductDao.findById(id);
//        em.getTransaction().begin();
//        Product productFromDB  = em.find(Product.class, id);
//        em.getTransaction().commit();
//        em.getTransaction().begin();
//
//        em.merge(productFromDB);
//
//        em.merge(product);

        shutdown();

    }

    public static void addProduct(Product product) {
        init();
        em.persist(product);
        shutdown();

    }


    private static void init() {
        getFactory();
        em = factory.createEntityManager();
        em.getTransaction().begin();
    }

    private static void getFactory() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SessionFactoryBean.class);
        factory = context.getBean(SessionFactory.class);
    }

    private static void shutdown() {
        em.getTransaction().commit();
        factory.close();
    }
}


