package com.example.musicshop.dto.address;

import lombok.Data;

@Data
public class UpdateAddressDto {

    private String street;

    private String city;

    private String streetNumber;

    private String postCode;

    private String country;
}
