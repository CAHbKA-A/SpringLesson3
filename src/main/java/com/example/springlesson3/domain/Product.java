package com.example.springlesson3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/*класс хранит только состояние и ни какой бизнеслогики*/
@Data
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id_products")
    private int id;

    @Column (name = "title_products")
    @NonNull
    private String title;

    @Column(name = "cost_products")
    @NonNull
    private int cost;

    @Column (name = "description_products")
    @NonNull
    private String description;



    @Column(name = "imgLink_products")
    @NonNull
    private String imgLink;


//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//            name = "categories",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id")
//    )
//    private Set<Category> categories;

}



