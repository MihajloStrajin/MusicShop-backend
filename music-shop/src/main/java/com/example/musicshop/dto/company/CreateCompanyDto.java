package com.example.musicshop.dto.company;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCompanyDto {

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    private String pib;

    @NotNull
    private String addressId;
}
