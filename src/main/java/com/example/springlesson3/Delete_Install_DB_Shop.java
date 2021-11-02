package com.example.springlesson3;
/*Первый старт.
 * Готовим БД для магазина*/


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Delete_Install_DB_Shop {
    public static SessionFactory factory;

    public static void main(String[] args) {
        try {
            init();
            crateNewProductsInDB();

        } finally {
            shutdown();
        }

        //test
        //  System.out.println(ProductDao.findById(1));
        //  System.out.println(ProductDao.findAll());
        //  ProductDao.deleteById(3);
        //   Product p1 = new Product("sadweq",22231,"3342132","44g45t");
        //  ProductDao.addProduct(new Product("sadweq", 22231, "3342132", "44g45t"));
        //  Product p2 = new Product("sa123123dweq", 22231, "3342132", "44g45t");
        //  SaveOrUpdate


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


