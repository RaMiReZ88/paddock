package com.example.paddock.dao.payment.repository;

import com.example.paddock.dao.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentHistoryRepository extends JpaRepository<Payment, Long> {

}
