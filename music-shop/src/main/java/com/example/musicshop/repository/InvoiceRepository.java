package com.example.musicshop.repository;

import com.example.musicshop.entity.Invoice;
import com.example.musicshop.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {

    List<Invoice> findAllByUser(User user);
}
