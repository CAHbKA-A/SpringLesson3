package com.example.springlesson3.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String nameCategory;

    @Column
    private String pathUrl;
}
