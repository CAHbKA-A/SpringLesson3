package com.example.springlesson3.util;

import com.example.springlesson3.domain.Product;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class Delete_ProductDao {
    //   private static SessionFactoryBean sessionFactoryBean;
    private final SessionFactoryBean sessionFactoryBean;
    //   public static ApplicationContext context = new AnnotationConfigApplicationContext(SessionFactoryBean.class);
    // private  final SessionFactoryBean sessionFactoryBean;
    public static Session factory;//= context.getBean(SessionFactory.class);
    public static EntityManager em;


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
        products = factory.createQuery("select p from Product p", Product.class).getResultList();
        shutdown();
        return products;
    }


    public static void deleteById(int id) {
        Product product = Delete_ProductDao.findById(id);
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
        factory.persist(product);
        shutdown();

    }

    public Product trfindById(int id) {
        Product product;
        //   SessionFactoryBean sessionFactoryBean = null;
        try (Session session = sessionFactoryBean.getFactoryBean().getCurrentSession()) {
            session.beginTransaction();
            product = em.find(Product.class, id);
            session.getTransaction().commit();
        }
        return product;
    }

    private static void init() {
        //    getFactory();
        //   Session  session = sessionFactoryBean.getFactoryBean().getCurrentSession();
        //  em = factory.createEntityManager();
        // session.beginTransaction();
        //  em.getTransaction().begin();
    }

//    private static void getFactory() {
//         factory = sessionFactoryBean.getFactoryBean().getCurrentSession();
//      //  ApplicationContext context = new AnnotationConfigApplicationContext(SessionFactoryBean.class);
//     //  factory = context.getBean(SessionFactory.class);
//    }

    private static void shutdown() {
        factory.getTransaction().commit();
        // factory.close();
    }
}


