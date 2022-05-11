package com.example.musicshop.controller;

import com.example.musicshop.dto.category.CreateProductCategoryDto;
import com.example.musicshop.dto.category.ProductCategoryResponseDto;
import com.example.musicshop.dto.category.UpdateProductCategoryDto;
import com.example.musicshop.entity.ProductCategory;
import com.example.musicshop.mapper.ProductCategoryMapper;
import com.example.musicshop.service.ProductCategoryService;
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
@RequestMapping("/api/categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @GetMapping
    public List<ProductCategoryResponseDto> getCategories(){
        return productCategoryMapper.mapEntityToResponse(productCategoryService.getCategories());
    }

    @GetMapping("/{uuid}")
    public ProductCategoryResponseDto getCategory(@PathVariable String uuid){
        return productCategoryMapper.mapEntityToResponse(productCategoryService.getCategory(uuid));
    }

    @PostMapping
    public ProductCategoryResponseDto create(@RequestBody CreateProductCategoryDto createProductCategoryDto){
        return productCategoryMapper.mapEntityToResponse(productCategoryService.create(createProductCategoryDto));
    }

    @PutMapping("/{uuid}")
    public ProductCategoryResponseDto update(@PathVariable String uuid, @RequestBody UpdateProductCategoryDto updateProductCategoryDto){
        return productCategoryMapper.mapEntityToResponse(productCategoryService.update(uuid, updateProductCategoryDto));
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid){
        productCategoryService.delete(uuid);
    }
}
