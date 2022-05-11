package com.example.musicshop.entity;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "comments")
public class Comment extends CreatedBase{

    @Column
    private String content;

    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(columnDefinition = "timestamp with time zone default now()", updatable = false, nullable = false)
    private OffsetDateTime commentedAt;

    @ManyToOne
    @JoinColumn(name = "fk_comment_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "fk_comment_user")
    private User user;
}
