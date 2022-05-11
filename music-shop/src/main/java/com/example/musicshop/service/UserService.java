package com.example.musicshop.service;

import com.example.musicshop.constants.ErrorCodes;
import com.example.musicshop.dto.address.CreateAddressDto;
import com.example.musicshop.dto.product.BuyProductDto;
import com.example.musicshop.dto.user.RegisterUserDto;
import com.example.musicshop.entity.Invoice;
import com.example.musicshop.entity.User;
import com.example.musicshop.exception.ConflictException;
import com.example.musicshop.exception.NotFoundException;
import com.example.musicshop.mapper.UserMapper;
import com.example.musicshop.repository.UserRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AddressService addressService;

    @Autowired
    @Lazy
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceProductService invoiceProductService;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public User findByName(String organizer, String errorCode) {
        return userRepository.findByName(organizer).orElseThrow(() -> {
            log.info("User with name '{}' does not exist.", organizer);
            throw new NotFoundException(errorCode);
        });
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public User findById(String uuid, String errorCode) {
        return userRepository.findById(uuid).orElseThrow(() -> {
            log.info("User with id '{}' does not exist.", uuid);
            throw new NotFoundException(errorCode);
        });
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public User register(RegisterUserDto registerUser) {
        if (userRepository.existsByName(registerUser.getName())) {
            throw new ConflictException(ErrorCodes.USER_ALREADY_EXISTS);
        }

        User user = userMapper.mapToEntity(registerUser);
        user.setAddress(addressService.create(new CreateAddressDto(registerUser.getStreet(), registerUser.getCity(), registerUser.getNumber(), registerUser.getPostalCode(), registerUser.getCountry())));

        user = userRepository.save(user);

        log.info("Successfully created {}.", user);
        return user;
    }

    public void buyProducts(String uuid, List<BuyProductDto> buyProductsDto) {
        User user = userRepository.findById(uuid).orElseThrow(() -> {throw new NotFoundException(ErrorCodes.PRODUCT_NOT_FOUND);});
        Invoice invoice = invoiceService.create(user);
        invoiceProductService.buyProducts(invoice, buyProductsDto);
    }
}
