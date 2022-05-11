package com.example.musicshop.repository;

import com.example.musicshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByName(String name);
}
