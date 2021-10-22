package com.example.springlesson3.domain.entity;

import com.example.springlesson3.domain.Category;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

//@Entity
public class ProductEntity {
    public class Product {
        private int id;
        private String title;
        private int cost;
        private String description;
        private Category categoryId;
        private String imgLink;
    }
}