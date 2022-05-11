package com.example.musicshop.entity;

import com.example.musicshop.entity.enums.UserType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User extends CreatedBase{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private UserType type;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "fk_user_address")
    private Address address;
}
