package com.example.springlesson3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "order_customer_id")
    @NonNull
    private int customerId;

    @Column(name = "order_total_cost")
    @NonNull
    private int cost;

    @Column(name = "order_status")
    @NonNull
    private String orderStatus;


    @Column(name = "order_update")
    @NonNull

    Date publicationDate;

    /*1 заказ может содержать несколько продутов*/
    /*один рлдукт может быть в нескольких заказах*/
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();


    /*несколько заказов могут принадлежать одному покупателю*/

    @ManyToOne
    @JoinColumn(name = "order_customer_id", insertable = false, updatable = false)
    private Customer customers;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", cost=" + cost +
                ", orderStatus='" + orderStatus + '\'' +
                ", publicationDate=" + publicationDate +

                '}';
    }
}
