package com.example.musicshop.dto.product;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateProductDto {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Long price;

    @NotNull
    private Long stock;

    private Long review;

    @NotNull
    private String companyId;

    @NotNull
    private String categoryId;
}
