package com.example.musicshop.controller;

import com.example.musicshop.dto.image.CreateImageDto;
import com.example.musicshop.dto.image.UpdateImageDto;
import com.example.musicshop.entity.Image;
import com.example.musicshop.service.ImageService;
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
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/{productId}")
    public List<Image> getImagesForProject(@PathVariable String productId){
        return imageService.getImageForProduct(productId);
    }

    @PostMapping
    public Image create(@RequestBody CreateImageDto createImageDto){
        return imageService.create(createImageDto);
    }

    @PutMapping("/{uuid}")
    public Image update(@PathVariable String uuid, @RequestBody UpdateImageDto updateImageDto){
        return imageService.update(uuid, updateImageDto);
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid){
        imageService.delete(uuid);
    }
}
