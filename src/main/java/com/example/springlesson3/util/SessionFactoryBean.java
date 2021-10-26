package com.example.springlesson3.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;


//@Configuration
//public class SessionFactoryBean {
//    SessionFactory factory;
//    @Bean
//    public SessionFactory init() {
//        factory = new org.hibernate.cfg.Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory();
//        System.out.println("factory created!!");
//        return factory;
//    }
//}
//

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