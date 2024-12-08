package com.example.payment_gateway_app.repository;

import com.example.payment_gateway_app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
