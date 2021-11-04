package com.example.springlesson3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @Column(name ="name_Category")
    @NonNull
    @NotBlank(message = "Название обязательно")
    private String nameCategory;

    @Column(name ="path_Url")
    @NotBlank(message = "Путь(Alias) обязательный")
    private String pathUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parentCategory;

//    @ManyToMany(mappedBy = "categories")
//    //private Set<Product> products = new HashSet<>();
//    private List<Product> products = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "parentCategory")
    @ToString.Exclude
    private Set<Category> subCategories;


    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )

    @ToString.Exclude
    private Set<Product> products;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return id != null && Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
