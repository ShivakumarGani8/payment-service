package com.ecommerce.PaymentService.repository;

import com.ecommerce.PaymentService.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionDetailsRepository extends JpaRepository<TransactionDetails,Long> {
}
