package com.example.musicshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="companies")
public class Company extends CreatedBase{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(unique = true, nullable = false)
    private String pib;

    @OneToOne
    @JoinColumn(name = "fk_company_address")
    private Address address;
}
