package com.example.springlesson3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private int id;

    @Column(name = "customer_id")
    @NonNull
    private int customerId;

    @Column(name = "total_cast")
    @NonNull
    private int cost;

    @Column(name = "order_status")
    @NonNull
    private String orderStatus;


    @Column(name = "order_update")
    @NonNull

    Date publicationDate;


//    @JsonIgnore
//    @OneToMany
//    @JoinTable(
//            name = "category",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id")
//    )
//    private Set<Category> categories;

}
