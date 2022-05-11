package com.example.musicshop.dto.image;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateImageDto {

    private String url;

    private String productId;
}
