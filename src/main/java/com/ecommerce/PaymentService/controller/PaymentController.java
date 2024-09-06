package com.ecommerce.PaymentService.controller;

import com.ecommerce.PaymentService.model.PaymentRequest;
import com.ecommerce.PaymentService.model.PaymentResponse;
import com.ecommerce.PaymentService.service.IPaymentService;
import jakarta.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("order/{id}")
    public ResponseEntity<PaymentResponse> getPaymentDetails(@PathVariable Long id){
        return new ResponseEntity<>(
                paymentService.getPaymentDetails(id),HttpStatus.OK);
    }
}
