package com.example.springlesson3.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearch {

    //поля по кот можем искать
    private Integer pageIndex;
    private Integer pagesSize = 10;
    private Integer pageNum;

    private String title;
    private Integer minCost ;
    private Integer maxCost;
    private List<Integer> idProductList;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortField = "title";
}
