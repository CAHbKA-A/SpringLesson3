package com.example.springlesson3.domain;

import com.example.springlesson3.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*класс хранит только состояние и ни какой бизнеслогики*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name = "products")
public class Product {
    @Id
    @GeneratedValue
    @Column (name = "id")
    private int id;

    @Column
    private String title;

    @Column
    private int cost;

    @Column
    private String description;

  //  private Category categoryId;

    @Column
    private String imgLink;



}



