package com.example.musicshop.service;

import com.example.musicshop.constants.ErrorCodes;
import com.example.musicshop.dto.category.CreateProductCategoryDto;
import com.example.musicshop.dto.category.UpdateProductCategoryDto;
import com.example.musicshop.entity.ProductCategory;
import com.example.musicshop.exception.ConflictException;
import com.example.musicshop.exception.NotFoundException;
import com.example.musicshop.mapper.ProductCategoryMapper;
import com.example.musicshop.repository.ProductCategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    public ProductCategory create(CreateProductCategoryDto createProductCategoryDto) {
        if (productCategoryRepository.findByCategoryName(createProductCategoryDto.getCategoryName()) != null){
            throw new ConflictException(ErrorCodes.PRODUCT_CATEGORY_FOUND);
        }

        ProductCategory create = productCategoryMapper.mapDtoToEntity(createProductCategoryDto);

        return productCategoryRepository.save(create);
    }

    public ProductCategory getCategory(String uuid){
        return productCategoryRepository.findById(uuid).orElseThrow(()->{
            throw new NotFoundException(ErrorCodes.PRODUCT_CATEGORY_NOT_FOUND);
        });
    }

    public List<ProductCategory> getCategories(){
        return productCategoryRepository.findAll();
    }

    public void delete(String uuid){
        ProductCategory delete = getCategory(uuid);

        productCategoryRepository.delete(delete);
    }

    public ProductCategory update(String uuid, UpdateProductCategoryDto updateProductCategoryDto){
        ProductCategory update = getCategory(uuid);

        if (productCategoryRepository.findByCategoryName(updateProductCategoryDto.getCategoryName()) != null){
            throw new ConflictException(ErrorCodes.PRODUCT_CATEGORY_FOUND);
        }

        update = productCategoryMapper.update(updateProductCategoryDto, update);

        return productCategoryRepository.save(update);
    }
}
