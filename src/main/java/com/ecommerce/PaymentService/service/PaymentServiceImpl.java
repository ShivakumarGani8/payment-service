package com.ecommerce.PaymentService.service;

import com.ecommerce.PaymentService.entity.TransactionDetails;
import com.ecommerce.PaymentService.exception.PaymentNotFoundException;
import com.ecommerce.PaymentService.model.ErrorCode;
import com.ecommerce.PaymentService.model.PaymentRequest;
import com.ecommerce.PaymentService.model.PaymentResponse;
import com.ecommerce.PaymentService.model.PaymentStatus;
import com.ecommerce.PaymentService.repository.ITransactionDetailsRepository;
import jakarta.inject.Inject;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

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
        log.info("Payment successful for order : {} ", paymentRequest.getOrderId());

        return transactionDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentDetails(Long orderId) {
        log.info("Getting payment details for order: {}",orderId);
        List<TransactionDetails> transactionDetailsList= transactionDetailsRepository.findByOrderId(orderId);
        TransactionDetails transactionDetails= transactionDetailsList.stream()
                .filter(transactions->transactions.getOrderId()==orderId)
                .findFirst()
                .orElseThrow(()->new PaymentNotFoundException("Payment not found for order Id",ErrorCode.PAYMENT_NOT_FOUND));
        PaymentResponse paymentResponse= PaymentResponse.builder()
                .referenceNumber(transactionDetails.getReferenceNumber())
                .amount(transactionDetails.getAmount())
                .paymentMode(transactionDetails.getPaymentMode())
                .build();
        return paymentResponse;
    }
}
