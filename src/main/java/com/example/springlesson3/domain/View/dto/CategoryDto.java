package com.example.springlesson3.domain.View.dto;

import lombok.*;


@Data
@Builder
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String title;
}
