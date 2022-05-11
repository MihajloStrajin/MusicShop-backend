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
@Table(name = "invoices_products")
public class InvoiceProduct extends CreatedBase{

    @ManyToOne
    @JoinColumn(name = "fk_ip_invoice")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "fk_ip_product")
    private Product product;

    @Column
    private Integer quantity;
}
