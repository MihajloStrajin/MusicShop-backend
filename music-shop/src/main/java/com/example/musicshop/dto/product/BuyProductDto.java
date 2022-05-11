package com.example.musicshop.dto.product;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyProductDto {

    @NotEmpty
    private int number;

    @NotEmpty
    private String product;
}
