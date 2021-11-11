package com.example.springlesson3.domain.View.dto;

import lombok.*;


@Data
@Builder
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoDefault {
    private Long id;

    private String title;

    private String description;

    private Double cost;

    private String imgLink;
}
