package com.ecommerce.PaymentService.entity;

import com.ecommerce.PaymentService.model.PaymentMode;
import com.ecommerce.PaymentService.model.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "PAYMENT_TABLE")
public class TransactionDetails {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PAYMENT_ID")
    @Id
    private long id;

    @Column(name = "ORDER_ID")
    private long orderId;

    @Column(name = "PAYMENT_MODE")
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;

    @Column(name = "PAYMENT_DATE")
    private Instant paymentDate;

    @Column(name = "PAYMENT_STATUS")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(name = "AMOUNT")
    private double amount;

}
