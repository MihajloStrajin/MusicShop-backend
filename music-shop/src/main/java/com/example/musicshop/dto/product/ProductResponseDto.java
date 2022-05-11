package com.example.musicshop.dto.product;

import lombok.Data;

@Data
public class ProductResponseDto {

    private String name;

    private Long price;

    private Long stock;
}
