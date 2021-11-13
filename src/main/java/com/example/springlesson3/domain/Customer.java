package com.example.springlesson3.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "customers")
public class Customer {


    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customer_name")
    @NonNull
    @NotBlank(message = "Название обязательно")
    private String customerName;

    @Column(name = "customer_balance")
    @NonNull
    private String customerBalance;


    /*1 покуптель может сделть много закзов*/
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customers")
    List<Order> orders;

    /*1 покуптель может сделть много закзов*/
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer_id")
    List<ProductOverview> overviews;
}
