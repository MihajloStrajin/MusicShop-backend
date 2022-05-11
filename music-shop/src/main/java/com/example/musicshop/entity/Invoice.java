package com.example.musicshop.entity;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Check(constraints = "(amount > 0) AND (numb_of_items > 0)")
@Table(name = "invoices")
public class Invoice extends CreatedBase{

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private Integer numbOfItems;

    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(columnDefinition = "timestamp with time zone default now()", updatable = false, nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    private boolean delivery;

    @Column(nullable = false)
    private Long deliveryCost;

    @ManyToOne
    @JoinColumn(name = "fk_invoice_user")
    private User user;
}
