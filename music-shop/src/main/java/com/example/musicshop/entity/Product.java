package com.example.musicshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends CreatedBase{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long stock;

    @Column
    private Long review;

    @ManyToOne
    @JoinColumn(name = "fk_product_company")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "fk_product_category")
    private ProductCategory productCategory;
}
