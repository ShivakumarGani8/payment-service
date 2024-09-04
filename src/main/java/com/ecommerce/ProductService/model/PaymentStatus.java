package com.ecommerce.ProductService.model;

public enum PaymentStatus {
    SUCCESS("success"),FAILED("failed");
    private final String status;
    PaymentStatus(String status){
        this.status=status;
    }
}
