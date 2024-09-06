package com.ecommerce.PaymentService.exception;

import com.ecommerce.PaymentService.model.ErrorCode;
import lombok.Data;

@Data
public class PaymentNotFoundException extends RuntimeException{
    private String message;
    private ErrorCode errorCode;

    public PaymentNotFoundException(String message,ErrorCode errorCode){
        super(message);
        this.message=message;
        this.errorCode=errorCode;
    }
}
