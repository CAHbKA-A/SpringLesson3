package com.example.springlesson3.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private int id;

    @Column
    private String nameCategory;

    @Column
    private String pathUrl;


    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();
}
