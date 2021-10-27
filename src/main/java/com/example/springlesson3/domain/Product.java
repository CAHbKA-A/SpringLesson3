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
    @Column(name = "id")
    private int id;

    @Column
    @NonNull
    private String title;

    @Column
    @NonNull
    private int cost;

    @Column
    @NonNull
    private String description;



    @Column
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



