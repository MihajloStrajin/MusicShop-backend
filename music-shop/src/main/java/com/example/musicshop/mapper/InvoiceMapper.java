package com.example.musicshop.mapper;

import com.example.musicshop.dto.invoice.InvoiceResponseDto;
import com.example.musicshop.entity.Invoice;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public abstract class InvoiceMapper {

    @Named("mapToResponse")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "amount")
    @Mapping(target = "numbOfItems")
    @Mapping(target = "user")
    @Mapping(target = "dateTime", source = "invoice.createdAt")
    public abstract InvoiceResponseDto mapToResponse(Invoice invoice);

    @IterableMapping(qualifiedByName = "mapToResponse")
    public abstract List<InvoiceResponseDto> mapToResponse(List<Invoice> invoices);
}
