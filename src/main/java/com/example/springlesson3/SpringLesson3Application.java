package com.example.springlesson3;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringLesson3Application {

    public static SessionFactory sessionFactory;
    public static void main(String[] args) {
     //   initDB();
        SpringApplication.run(SpringLesson3Application.class, args);
    }

//    private static void initDB(){
//        sessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory();
//    }

}
