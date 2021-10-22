package com.example.springlesson3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {//регистор ресурсов обрабатывает запросы ш
        String imgFolder = "img";

        String staticPath = Paths.get(System.getProperty("user.dir"), imgFolder).toFile().getAbsolutePath();

        // фильтруем урл . если ...8080/img/**, то идем в папку по асб пути staticPath
        registry.addResourceHandler("/" + imgFolder + "/**").addResourceLocations("file:/" + staticPath + "/"); // абс путь до папаки с картинками
    }
}
