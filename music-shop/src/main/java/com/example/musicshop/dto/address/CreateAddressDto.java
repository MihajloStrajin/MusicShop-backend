package com.example.musicshop.dto.address;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateAddressDto {

    @NotNull
    private String street;

    @NotNull
    private String city;

    @NotNull
    private String streetNumber;

    @NotNull
    private String postCode;

    @NotNull
    private String country;
}
