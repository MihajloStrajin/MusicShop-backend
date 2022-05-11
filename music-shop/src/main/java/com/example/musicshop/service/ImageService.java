package com.example.musicshop.service;

import com.example.musicshop.constants.ErrorCodes;
import com.example.musicshop.dto.image.CreateImageDto;
import com.example.musicshop.dto.image.UpdateImageDto;
import com.example.musicshop.entity.Image;
import com.example.musicshop.entity.Product;
import com.example.musicshop.exception.NotFoundException;
import com.example.musicshop.mapper.ImageMapper;
import com.example.musicshop.repository.ImageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired //Dependency injection (tako zna koji imageRepo da mi dodeli, ako ne zna koji onda se koriste Bean-ovi)
    //Drugi nacin izbrise se Autowired i iznad klase se doda RequiredArgsConstructor i final u deklaraciji
    private ImageRepository imageRepository;

    @Autowired
    private ImageMapper imageMapper;

    @Autowired
    private ProductService productService;

    public Image create(CreateImageDto createImageDto){
        if(productService.getProduct(createImageDto.getProductId())==null){
            throw new NotFoundException(ErrorCodes.PRODUCT_NOT_FOUND);
        }

        Product foundProduct = productService.getProduct(createImageDto.getProductId());

        Image create = imageMapper.mapDtoToEntity(createImageDto);
        create.setProduct(foundProduct);

        return imageRepository.save(create);
    }

    public Image getImage(String uuid){
        return imageRepository.findById(uuid).orElseThrow(()->{
            throw new NotFoundException(ErrorCodes.IMAGE_NOT_FOUND);
        });
    }

    public List<Image> getImageForProduct(String uuid){
        if(productService.getProduct(uuid)==null){
            throw new NotFoundException(ErrorCodes.PRODUCT_NOT_FOUND);
        }

        Product foundProduct = productService.getProduct(uuid);

        List<Image> images = imageRepository.findByProduct(foundProduct);

        if(images.size() == 0){
            throw new NotFoundException(ErrorCodes.IMAGE_NOT_FOUND);
        }

        return images;
    }

    public Image update(String uuid, UpdateImageDto updateImageDto){
        if(updateImageDto.getProductId() != null && productService.getProduct(updateImageDto.getProductId())==null){
            throw new NotFoundException(ErrorCodes.PRODUCT_NOT_FOUND);
        }

        Image update = getImage(uuid);

        update = imageMapper.update(updateImageDto, update);

        if(updateImageDto.getProductId() != null){
            Product foundProduct = productService.getProduct(updateImageDto.getProductId());
            update.setProduct(foundProduct);
        }

        return imageRepository.save(update);
    }

    public void delete(String uuid){
        Image delete = getImage(uuid);

        imageRepository.delete(delete);
    }
}
