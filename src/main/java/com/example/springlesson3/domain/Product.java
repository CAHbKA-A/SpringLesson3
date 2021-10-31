package com.example.springlesson3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/*класс хранит только состояние и ни какой бизнеслогики*/
@Data
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id_product")
    private int id;

    @Column(name = "title_product")
    @NonNull
    private String title;

    @Column(name = "cost_product")
    @NonNull
    private int cost;

    @Column(name = "description_product")
    @NonNull
    private String description;


    @Column(name = "imgLink_product")
    @NonNull
    private String imgLink;


    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;


    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> orders;


}



