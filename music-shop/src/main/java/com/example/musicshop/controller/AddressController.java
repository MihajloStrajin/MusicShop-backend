package com.example.musicshop.controller;

import com.example.musicshop.dto.address.AddressResponseDto;
import com.example.musicshop.dto.address.CreateAddressDto;
import com.example.musicshop.dto.address.UpdateAddressDto;
import com.example.musicshop.entity.Address;
import com.example.musicshop.mapper.AddressMapper;
import com.example.musicshop.service.AddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressMapper addressMapper;

    @GetMapping
    public List<AddressResponseDto> getAddresses(){
        return addressMapper.mapEntityToResponse(addressService.getAddresses());
    }

    @GetMapping("/{uuid}")
    public AddressResponseDto getAddress(@PathVariable String uuid){
        return addressMapper.mapEntityToResponse(addressService.getAddress(uuid));
    }

    @PostMapping
    public AddressResponseDto create(@RequestBody CreateAddressDto createAddressDto){
        return addressMapper.mapEntityToResponse(addressService.create(createAddressDto));
    }

    @PutMapping("/{uuid}")
    public AddressResponseDto update(@PathVariable String uuid,@RequestBody UpdateAddressDto updateAddressDto){
        return addressMapper.mapEntityToResponse(addressService.update(uuid, updateAddressDto));
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid){
        addressService.delete(uuid);
    }
}
