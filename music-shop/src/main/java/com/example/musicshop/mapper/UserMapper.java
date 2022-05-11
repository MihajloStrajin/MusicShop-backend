package com.example.musicshop.mapper;

import com.example.musicshop.dto.user.RegisterUserDto;
import com.example.musicshop.dto.user.UserResponseDto;
import com.example.musicshop.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public abstract class UserMapper {

    @Named("mapToResponse")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name")
    @Mapping(target = "phoneNumber")
    @Mapping(target = "email")
    @Mapping(target = "address")
    public abstract UserResponseDto mapToResponse(User user);

    @Named("mapToEntity")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name")
    @Mapping(target = "phoneNumber")
    @Mapping(target = "email")
    public abstract User mapToEntity(RegisterUserDto registerUser);
}
