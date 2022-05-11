package com.example.musicshop.mapper;

import com.example.musicshop.dto.company.CompanyResponseDto;
import com.example.musicshop.dto.company.CreateCompanyDto;
import com.example.musicshop.dto.company.UpdateCompanyDto;
import com.example.musicshop.entity.Company;
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
public abstract class CompanyMapper {

    @Named("mapDtoToEntity")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name")
    @Mapping(target = "phone")
    @Mapping(target = "pib")
    public abstract Company mapToEntity(CreateCompanyDto createCompanyDto);

    @Named("update")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name")
    @Mapping(target = "phone")
    @Mapping(target = "pib")
    public abstract Company update(UpdateCompanyDto updateCompanyDto, @MappingTarget Company company);

    @Named("mapEntityToResponse")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name")
    @Mapping(target = "pib")
    public abstract CompanyResponseDto mapEntityToResponse(Company company);

    @IterableMapping(qualifiedByName = "mapEntityToResponse")
    public abstract List<CompanyResponseDto> mapEntityToResponse(List<Company> companies);
}
