package com.example.springlesson3.domain;

import com.example.springlesson3.domain.Category;
import lombok.*;

import javax.persistence.*;

/*класс хранит только состояние и ни какой бизнеслогики*/
@Data
//@Builder
//@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table (name = "products")
public class Product {
    @Id
    @GeneratedValue
    @Column (name = "id")
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

  //  private Category categoryId;

    @Column
    @NonNull
    private String imgLink;



}



