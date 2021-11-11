package com.example.springlesson3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*класс хранит только состояние и ни какой бизнеслогики*/
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;

    @Column(name = "title_product")
    @NonNull
    @NotBlank(message = "Название обязательно")
    //  @NaturalId
    private String title;

    @Column(name = "cost_product")
    @NotNull(message = "Цена обязательна")

    private Long cost;

    @Column(name = "description_product")
    @NonNull
    private String description;


    @Column(name = "imglink_product")
    @NonNull
    private String imgLink;


 //   @JsonIgnore// чтобы не зацикливался при преобразовании в json
    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
   @ToString.Exclude
    private Set<Category> categories = new HashSet<>();


    @JsonIgnore // чтобы не зацикливался при преобразовании в json
    @ManyToMany
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> orders;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product_id")
    @ToString.Exclude
    private Set<ProductOverview> productOverview;




}



