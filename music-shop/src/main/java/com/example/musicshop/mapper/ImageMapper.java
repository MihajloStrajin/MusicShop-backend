package com.example.musicshop.mapper;

import com.example.musicshop.dto.image.CreateImageDto;
import com.example.musicshop.dto.image.UpdateImageDto;
import com.example.musicshop.entity.Image;
import org.mapstruct.BeanMapping;
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
public abstract class ImageMapper {

    @Named("mapDtoToEntity")
    @BeanMapping(ignoreByDefault = true) // ne radi se automatsko mapiranje, nego samo ono koje je eksplicitno navedeno preko @Mapping ispod
    @Mapping(target = "url")
    public abstract Image mapDtoToEntity(CreateImageDto createImageDto);

    @Named("update")
    @BeanMapping(ignoreByDefault = true) // ne radi se automatsko mapiranje, nego samo ono koje je eksplicitno navedeno preko @Mapping ispod
    @Mapping(target = "url")
    public abstract Image update(UpdateImageDto updateImageDto, @MappingTarget Image image);
}
