package com.example.springlesson3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Objects;
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
    private Long id;

    @Column(name ="name_Category")
    @NonNull
    @NotBlank(message = "Название обязательно")
    private String nameCategory;

    @Column(name ="path_Url")
    @NotBlank(message = "Путь(Alias) обязательный")
    private String pathUrl;

    @Column(name = "parent_id")
    private int parentId ;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "parentId")
    @ToString.Exclude
    private Set<Category> subCategories;

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
