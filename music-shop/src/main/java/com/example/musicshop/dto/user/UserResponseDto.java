package com.example.musicshop.dto.user;

import com.example.musicshop.entity.Address;
import com.example.musicshop.entity.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String name;

    private String phoneNumber;

    private String email;

    private UserType type;

    private Address address;
}
