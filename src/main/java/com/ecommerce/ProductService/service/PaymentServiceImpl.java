package com.ecommerce.ProductService.service;

import com.ecommerce.ProductService.entity.TransactionDetails;
import com.ecommerce.ProductService.model.PaymentRequest;
import com.ecommerce.ProductService.model.PaymentStatus;
import com.ecommerce.ProductService.repository.ITransactionDetailsRepository;
import jakarta.inject.Inject;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Log4j2
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Inject
    private ITransactionDetailsRepository transactionDetailsRepository;

    @Override
    public long makePayment(PaymentRequest paymentRequest) {
        log.info("Making payment for order {} ", paymentRequest.getOrderId());
        TransactionDetails transactionDetails= TransactionDetails.builder()
                .orderId(paymentRequest.getOrderId())
                .paymentMode(paymentRequest.getPaymentMode())
                .paymentStatus(PaymentStatus.SUCCESS)
                .paymentDate(Instant.now())
                .amount(paymentRequest.getAmount())
                .build();
        transactionDetailsRepository.save(transactionDetails);

        return transactionDetails.getId();
    }
}
