package com.example.musicshop.controller;

import com.example.musicshop.dto.product.CreateProductDto;
import com.example.musicshop.dto.product.ProductResponseDto;
import com.example.musicshop.dto.product.UpdateProductDto;
import com.example.musicshop.mapper.ProductMapper;
import com.example.musicshop.service.ProductService;
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
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping
    public List<ProductResponseDto> getProducts(){
        return productMapper.mapEntityToResponse(productService.getProducts());
    }

    @GetMapping("/{uuid}")
    public ProductResponseDto getProduct(@PathVariable String uuid){
        return productMapper.mapEntityToResponse(productService.getProduct(uuid));
    }

    @PostMapping
    public ProductResponseDto create(@RequestBody CreateProductDto createProductDto){
        return productMapper.mapEntityToResponse(productService.create(createProductDto));
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid){
        productService.delete(uuid);
    }

    @PutMapping("/{uuid}")
    public ProductResponseDto update(@PathVariable String uuid, @RequestBody UpdateProductDto updateProductDto){
        return productMapper.mapEntityToResponse(productService.update(uuid, updateProductDto));
    }
}
