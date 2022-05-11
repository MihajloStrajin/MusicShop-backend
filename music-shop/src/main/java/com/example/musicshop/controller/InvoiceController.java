package com.example.musicshop.controller;

import com.example.musicshop.dto.invoice.InvoiceResponseDto;
import com.example.musicshop.mapper.InvoiceMapper;
import com.example.musicshop.service.InvoiceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceMapper invoiceMapper;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InvoiceResponseDto>> getAll() {
        return ResponseEntity.ok(invoiceMapper.mapToResponse(invoiceService.findAll()));
    }

    @GetMapping(value = "/{uuid}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InvoiceResponseDto>> getAllByUser(@RequestParam String uuid) {
        return ResponseEntity.ok(invoiceMapper.mapToResponse(invoiceService.findAllByUser(uuid)));
    }
}
