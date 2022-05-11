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
@Table(name = "images")
public class Image extends CreatedBase{

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "fk_image_product")
    private Product product;

}
