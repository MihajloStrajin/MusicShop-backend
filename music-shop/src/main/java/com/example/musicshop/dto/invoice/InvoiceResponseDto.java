package com.example.musicshop.dto.invoice;

import com.example.musicshop.entity.User;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class InvoiceResponseDto {

    private Long amount;

    private Integer numbOfItems;

    private OffsetDateTime dateTime;

    private User user;
}
