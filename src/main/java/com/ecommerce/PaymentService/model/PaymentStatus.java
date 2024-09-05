package com.ecommerce.PaymentService.model;

public enum PaymentStatus {
    INITIATED("INITIATED"),SUCCESS("SUCCESS"),FAILED("SUCCESS");
    private final String status;
    PaymentStatus(String status){
        this.status=status;
    }
}
