package com.example.musicshop.dto.product;

import lombok.Data;

@Data
public class UpdateProductDto {

    private String name;

    private String description;

    private Long price;

    private Long stock;

    private Long review;

    private String companyId;

    private String categoryId;
}
