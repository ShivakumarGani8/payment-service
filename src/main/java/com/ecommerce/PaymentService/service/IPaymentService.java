package com.ecommerce.PaymentService.service;

import com.ecommerce.PaymentService.model.PaymentRequest;
import com.ecommerce.PaymentService.model.PaymentResponse;

public interface IPaymentService {
    long makePayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetails(Long id);
}
