package com.example.musicshop.service;

import com.example.musicshop.dto.product.BuyProductDto;
import com.example.musicshop.entity.Invoice;
import com.example.musicshop.entity.InvoiceProduct;
import com.example.musicshop.repository.InvoiceProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceProductService {

    @Autowired
    private InvoiceProductRepository invoiceProductRepository;

    @Autowired
    private ProductService productService;

    public void create(List<InvoiceProduct> invoiceProducts) {
        invoiceProductRepository.saveAll(invoiceProducts);
    }

    public void buyProducts(Invoice invoice, List<BuyProductDto> buyProductsDto) {
        InvoiceProduct invoiceProduct = new InvoiceProduct();
        List<InvoiceProduct> productsList = new ArrayList<>();
        buyProductsDto.forEach(buyProductDto -> {
            invoiceProduct.setProduct(productService.getProduct(buyProductDto.getProduct()));
            invoiceProduct.setInvoice(invoice);
            invoiceProduct.setQuantity(buyProductDto.getNumber());

            productsList.add(invoiceProduct);
        });

        create(productsList);
    }
}
