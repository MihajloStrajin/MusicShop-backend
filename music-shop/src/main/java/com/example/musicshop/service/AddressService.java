package com.example.musicshop.service;

import com.example.musicshop.constants.ErrorCodes;
import com.example.musicshop.dto.address.CreateAddressDto;
import com.example.musicshop.dto.address.UpdateAddressDto;
import com.example.musicshop.entity.Address;
import com.example.musicshop.exception.NotFoundException;
import com.example.musicshop.mapper.AddressMapper;
import com.example.musicshop.repository.AddressRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    public Address create(CreateAddressDto createAddressDto){
        Address create = addressMapper.mapDtoToEntity(createAddressDto);

        return addressRepository.save(create);
    }

    public Address getAddress(String uuid){
        return addressRepository.findById(uuid).orElseThrow(()->{
            throw new NotFoundException(ErrorCodes.ADDRESS_NOT_FOUND);
        });
    }

    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public void delete(String uuid){
        Address delete = getAddress(uuid);

        addressRepository.delete(delete);
    }

    public Address update(String uuid, UpdateAddressDto updateAddressDto){
        Address update = getAddress(uuid);

        update = addressMapper.update(updateAddressDto, update);

        return addressRepository.save(update);
    }
}
