package com.example.musicshop.mapper;

import com.example.musicshop.dto.category.CreateProductCategoryDto;
import com.example.musicshop.dto.category.ProductCategoryResponseDto;
import com.example.musicshop.dto.category.UpdateProductCategoryDto;
import com.example.musicshop.entity.ProductCategory;
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
public abstract class ProductCategoryMapper {

    @Named("mapDtoToEntity")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "categoryName")
    public abstract ProductCategory mapDtoToEntity(CreateProductCategoryDto createProductCategoryDto);

    @Named("mapEntityToResponse")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "categoryName")
    public abstract ProductCategoryResponseDto mapEntityToResponse(ProductCategory productCategory);

    @Named("update")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "categoryName")
    public abstract ProductCategory update(UpdateProductCategoryDto updateProductCategoryDto, @MappingTarget ProductCategory productCategory);

    @IterableMapping(qualifiedByName = "mapEntityToResponse")
    public abstract List<ProductCategoryResponseDto> mapEntityToResponse(List<ProductCategory> productCategories);
}
