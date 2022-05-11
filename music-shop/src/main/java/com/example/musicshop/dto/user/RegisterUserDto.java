package com.example.musicshop.dto.user;

import com.example.musicshop.entity.enums.UserType;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String email;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private UserType type;

    @NotEmpty
    private String street;

    @NotEmpty
    private String number;

    @NotEmpty
    private String city;

    @NotEmpty
    private String postalCode;

    @NotEmpty
    private String country;
}
