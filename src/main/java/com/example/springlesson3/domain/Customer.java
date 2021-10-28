package com.example.springlesson3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
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
    private String customerName;

    @Column(name = "customer_balance")
    @NonNull
    private String customerBalance;

/*1 покуптель может сделть много закзов*/
   // @JsonIgnore
    @OneToMany(mappedBy = "customers")
         List<Order> orders ;
}
