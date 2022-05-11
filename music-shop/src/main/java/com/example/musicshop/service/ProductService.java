package com.example.musicshop.service;

import com.example.musicshop.constants.ErrorCodes;
import com.example.musicshop.dto.product.CreateProductDto;
import com.example.musicshop.dto.product.UpdateProductDto;
import com.example.musicshop.entity.Product;
import com.example.musicshop.exception.ConflictException;
import com.example.musicshop.exception.NotFoundException;
import com.example.musicshop.mapper.ProductMapper;
import com.example.musicshop.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public Product create(CreateProductDto createProductDto) {
        if(productRepository.findByName(createProductDto.getName())!=null){
            throw new ConflictException(ErrorCodes.PRODUCT_FOUND);
        }

        Product create = productMapper.mapDtoToEntity(createProductDto);

        return productRepository.save(create);
    }

    public Product getProduct(String uuid){
        return productRepository.findById(uuid).orElseThrow(()->{
           throw new NotFoundException(ErrorCodes.PRODUCT_NOT_FOUND);
        });
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product update(String uuid, UpdateProductDto updateProductDto){
        if(updateProductDto.getName()!=null && productRepository.findByName(updateProductDto.getName())!=null){
            throw new ConflictException(ErrorCodes.PRODUCT_FOUND);
        }

        Product update = getProduct(uuid);

        update = productMapper.update(updateProductDto, update);

        return productRepository.save(update);
    }

    public void delete(String uuid){
        Product delete = getProduct(uuid);

        productRepository.delete(delete);
    }
}
