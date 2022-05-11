package com.example.musicshop.mapper;

import com.example.musicshop.dto.address.AddressResponseDto;
import com.example.musicshop.dto.address.CreateAddressDto;
import com.example.musicshop.dto.address.UpdateAddressDto;
import com.example.musicshop.entity.Address;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public abstract class AddressMapper {

    @Named("mapDtoToEntity")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "street")
    @Mapping(target = "city")
    @Mapping(target = "streetNumber")
    @Mapping(target = "postCode")
    @Mapping(target = "country")
    public abstract Address mapDtoToEntity(CreateAddressDto createAddressDto);

    @Named("update")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "street")
    @Mapping(target = "city")
    @Mapping(target = "streetNumber")
    @Mapping(target = "postCode")
    @Mapping(target = "country")
    public abstract Address update(UpdateAddressDto updateAddressDto, @MappingTarget Address address);

    @Named("mapEntityToResponse")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "fullStreet", expression = "java(address.getStreet() + \" \" + address.getStreetNumber())")
    @Mapping(target = "city")
    @Mapping(target = "country")
    public abstract AddressResponseDto mapEntityToResponse(Address address);

    @IterableMapping(qualifiedByName = "mapEntityToResponse")
    public abstract List<AddressResponseDto> mapEntityToResponse(List<Address> addresses);
}
