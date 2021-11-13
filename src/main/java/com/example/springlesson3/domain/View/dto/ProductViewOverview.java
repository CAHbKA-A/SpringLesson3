package com.example.springlesson3.domain.View.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductViewOverview {

private int id;
    private String overviewText;
    private Long CustomerId;
    private Integer rate;
    private LocalDateTime addedDate;
    private LocalDateTime modifyDate;

}
