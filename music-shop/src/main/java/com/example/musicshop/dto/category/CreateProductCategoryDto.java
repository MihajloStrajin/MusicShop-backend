package com.example.musicshop.dto.category;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateProductCategoryDto {

    @NotNull
    private String categoryName;
}
