package com.example.springlesson3;


import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringLesson3Application {

    public static SessionFactory factory;
    public static void main(String[] args) {


//        ApplicationContext context = new AnnotationConfigApplicationContext(SessionFactoryBean.class);
//        factory = context.getBean(SessionFactory.class);

       SpringApplication.run(SpringLesson3Application.class, args);
    }


}
