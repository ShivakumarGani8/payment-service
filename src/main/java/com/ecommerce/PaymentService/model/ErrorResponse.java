package com.ecommerce.PaymentService.model;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private ErrorCode errorCode;
}
