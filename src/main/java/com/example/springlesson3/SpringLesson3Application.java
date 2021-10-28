package com.example.springlesson3;


import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringLesson3Application {

    public static SessionFactory factory;
    public static void main(String[] args) {

//        Flyway flyway = Flyway.configure()
//                .dataSource("jdbc:postgresql://localhost:5432/", "postgres", "root")
//                .load();
//        flyway.migrate();
       SpringApplication.run(SpringLesson3Application.class, args);
    }


}
