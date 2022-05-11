package com.example.musicshop.mapper;

import com.example.musicshop.dto.product.CreateProductDto;
import com.example.musicshop.dto.product.ProductResponseDto;
import com.example.musicshop.dto.product.UpdateProductDto;
import com.example.musicshop.entity.Product;
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
public abstract class ProductMapper {

    @Named("mapDtoToEntity")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name")
    @Mapping(target = "description")
    @Mapping(target = "price")
    @Mapping(target = "stock")
    @Mapping(target = "review")
    public abstract Product mapDtoToEntity(CreateProductDto createProductDto);

    @Named("mapEntityToResponse")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name")
    @Mapping(target = "price")
    @Mapping(target = "stock")
    public abstract ProductResponseDto mapEntityToResponse(Product product);

    @Named("update")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name")
    @Mapping(target = "description")
    @Mapping(target = "price")
    @Mapping(target = "stock")
    @Mapping(target = "review")
    public abstract Product update(UpdateProductDto updateProductDto, @MappingTarget Product product);

    @IterableMapping(qualifiedByName = "mapEntityToResponse")
    public abstract List<ProductResponseDto> mapEntityToResponse(List<Product> products);
}
