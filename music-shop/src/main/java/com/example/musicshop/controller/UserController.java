package com.example.musicshop.controller;

import com.example.musicshop.dto.product.BuyProductDto;
import com.example.musicshop.dto.user.RegisterUserDto;
import com.example.musicshop.entity.User;
import com.example.musicshop.mapper.UserMapper;
import com.example.musicshop.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> register(@RequestBody final RegisterUserDto registerUser) {
        final User user = userService.register(registerUser);

        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{uuid}/buyProduct", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> buyProduct(@RequestParam("uuid") final String uuid,
                                          @RequestBody List<BuyProductDto> buyProductsDto) {
        userService.buyProducts(uuid, buyProductsDto);

        return ResponseEntity.noContent().build();
    }
}
