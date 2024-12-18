package com.example.payment_gateway_app.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_transaction")
@Getter
@Setter
public class Transaction extends Auditable<String> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String paymentMethod;
    private Double amount;
    private String status;
    private String role;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    private Employee employee;
}