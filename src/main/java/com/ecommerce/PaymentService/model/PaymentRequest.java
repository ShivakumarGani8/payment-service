package com.ecommerce.PaymentService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private long orderId;
    private PaymentMode paymentMode;
    private String referenceNumber;
    private double amount;

}
