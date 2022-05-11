package com.example.musicshop.service;

import com.example.musicshop.constants.ErrorCodes;
import com.example.musicshop.entity.Invoice;
import com.example.musicshop.entity.User;
import com.example.musicshop.exception.NotFoundException;
import com.example.musicshop.repository.InvoiceRepository;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.FetchType;

@Slf4j
@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    @Lazy
    private UserService userService;

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public Invoice create(User user) {
        Invoice invoice = new Invoice();

        invoice.setUser(user);
        invoice.setNumbOfItems(0);
        invoice.setAmount(0L);

        invoice = invoiceRepository.save(invoice);

        return invoice;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Invoice findById(String uuid) {
        return invoiceRepository.findById(uuid).orElseThrow(()->{
            log.info("Invoice with id '{}' does not exist.", uuid);
            throw new NotFoundException(ErrorCodes.INVOICE_NOT_FOUND);
        });
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Invoice> findAllByUser(String uuid) {
        User user = userService.findById(uuid, ErrorCodes.USER_NOT_FOUND_BY_ID);

        return invoiceRepository.findAllByUser(user);
    }
}
