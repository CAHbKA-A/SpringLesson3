package com.example.springlesson3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

    @Data
    @RequiredArgsConstructor
    @NoArgsConstructor

    @Entity
    @Table(name = "customers")
    public class Customer {
        @Id
        @GeneratedValue
        @Column(name = "id")
        private int id;

        @Column(name = "customer_name")
        @NonNull
        private String customerName;

        @Column  (name = "customer_balance")
        @NonNull
        private String customerBalance;

    }
