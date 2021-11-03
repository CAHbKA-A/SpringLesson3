package com.example.springlesson3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.transform.Source;
import java.util.HashSet;
import java.util.Set;

/*класс хранит только состояние и ни какой бизнеслогики*/
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer id;

    @Column(name = "title_product")
    @NonNull
    @NotBlank(message = "Название обязательно")
    //  @NaturalId
    private String title;

    @Column(name = "cost_product")
    @NotNull(message = "Цена обязательна")

    private Integer cost;

    @Column(name = "description_product")
    @NonNull
    private String description;


    @Column(name = "imglink_product")
    @NonNull
    private String imgLink;


    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @ToString.Exclude// что это?
    private Set<Category> categories = new HashSet<>();


    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> orders;


    @Override
    public void setSystemId(String systemId) {

    }

    @Override
    public String getSystemId() {
        return null;
    }
}



