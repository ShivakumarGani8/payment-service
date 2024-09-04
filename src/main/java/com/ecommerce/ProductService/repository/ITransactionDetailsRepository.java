package com.ecommerce.ProductService.repository;

import com.ecommerce.ProductService.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionDetailsRepository extends JpaRepository<TransactionDetails,Long> {
}
