package com.example.musicshop.repository;

import com.example.musicshop.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
    Company findByPib(String pib);
    Company findByName(String name);
}
