package com.ecommerce.PaymentService.exception;

import com.ecommerce.PaymentService.model.ErrorCode;

public class PaymentNotFoundException extends RuntimeException{
    private String message;

    public PaymentNotFoundException(String message,ErrorCode errorCode){
        super(message);
        this.message=message;
    }
}
