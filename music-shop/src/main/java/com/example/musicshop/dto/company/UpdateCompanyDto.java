package com.example.musicshop.dto.company;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateCompanyDto {

    private String name;

    private String phone;

    private String pib;

    private String addressId;
}
