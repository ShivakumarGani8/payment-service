package com.ecommerce.ProductService.controller;

import com.ecommerce.ProductService.model.PaymentRequest;
import com.ecommerce.ProductService.service.IPaymentService;
import jakarta.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Inject
    private IPaymentService paymentService;

    @PostMapping("/doPayment")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>
                (paymentService.makePayment(paymentRequest), HttpStatus.OK);
    }
}
