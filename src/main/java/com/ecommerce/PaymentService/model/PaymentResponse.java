package com.ecommerce.PaymentService.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponse {
    private PaymentMode paymentMode;
    private String referenceNumber;
    private double amount;
}
