package com.ecommerce.PaymentService.service;

import com.ecommerce.PaymentService.model.PaymentRequest;

public interface IPaymentService {
    long makePayment(PaymentRequest paymentRequest);
}
