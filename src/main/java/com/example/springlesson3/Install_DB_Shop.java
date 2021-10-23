package com.example.springlesson3;
/*Первый старт.
 * Готовим БД для магазина*/

import com.example.springlesson3.domain.Product;
import com.example.springlesson3.util.ProductDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Install_DB_Shop {
    public static SessionFactory factory;

    public static void main(String[] args) {
        try {
            init();
            crateNewProductsInDB();

        } finally {
            shutdown();
        }

      //  System.out.println(ProductDao.findById(1));
       // System.out.println(ProductDao.findAll());
     //   ProductDao.deleteById(2);
        Product product = ProductDao.findById(2);
        ProductDao.deleteById(product);

    }

    private static void crateNewProductsInDB() {
        try (Session session = factory.getCurrentSession()) {
            String sqlQuery = Files.lines(Paths.get("fillDB.sql")).collect(Collectors.joining(" "));
            session.beginTransaction();
            session.createNativeQuery(sqlQuery).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
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


