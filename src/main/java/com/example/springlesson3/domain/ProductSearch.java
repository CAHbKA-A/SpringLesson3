package com.example.springlesson3.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearch {

    //поля по кот можем искать
    private int pageIndex;
    private int size = 10;
    private String title;
    private Integer minCost ;
    private Integer maxCost;
    private List<Integer> idProductList;
}
