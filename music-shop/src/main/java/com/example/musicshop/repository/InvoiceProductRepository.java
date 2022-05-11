package com.example.musicshop.repository;

import com.example.musicshop.entity.InvoiceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct, String> {

}
