package com.ecommerce.PaymentService.repository;

import com.ecommerce.PaymentService.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITransactionDetailsRepository extends JpaRepository<TransactionDetails,Long> {
    @Query(value = "select * from PAYMENT_TABLE PT where PT.ORDER_ID=?",nativeQuery = true)
    List<TransactionDetails> findByOrderId(Long orderId);
}
