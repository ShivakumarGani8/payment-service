package com.ecommerce.ProductService.service;

import com.ecommerce.ProductService.model.PaymentRequest;
import org.springframework.http.ResponseEntity;

public interface IPaymentService {
    long makePayment(PaymentRequest paymentRequest);
}
