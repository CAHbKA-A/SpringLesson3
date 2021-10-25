package com.example.springlesson3.util;


import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SessionFactoryBean {
    SessionFactory factory;
    @Bean
    public SessionFactory init() {
        factory = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        System.out.println("factory created!!");
        return factory;
    }
}


//
//@Component("sessio")
//
//public class SessionFactoryBean {
//
//    private static SessionFactoryBean factory;
//
//
//    private SessionFactoryBean() {
//        factory = (SessionFactoryBean) new Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory();
//        System.out.println("factory created!!");
//
//    }
//
//@Bean
//    public  SessionFactoryBean getFactory() {
//        return factory;
//    }
//
//}
