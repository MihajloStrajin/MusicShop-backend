package com.example.musicshop.repository;

import com.example.musicshop.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {
    ProductCategory findByCategoryName(String name);
}
