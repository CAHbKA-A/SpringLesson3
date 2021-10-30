package com.example.springlesson3.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;


@Component
public class SessionFactoryBean {

    private final SessionFactory factory;

    public SessionFactoryBean() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        System.out.println("factory created!!");
    }


    public SessionFactory getFactoryBean() {
        return factory;
    }

}