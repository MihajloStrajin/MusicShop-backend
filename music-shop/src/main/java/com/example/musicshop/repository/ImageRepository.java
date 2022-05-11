package com.example.musicshop.repository;

import com.example.musicshop.entity.Image;
import com.example.musicshop.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
    List<Image> findByProduct(Product product);
}
