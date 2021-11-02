package com.example.springlesson3.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
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

    @Column(name ="nameCategory")
    private String nameCategory;

    @Column(name ="pathUrl")
    private String pathUrl;


    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();
}
