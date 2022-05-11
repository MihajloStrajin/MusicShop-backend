package com.example.musicshop.dto.image;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data //sadrzi gettere settere tostring itd.
public class CreateImageDto {

    @NotNull
    private String url;

    @NotNull
    private String productId;
}
