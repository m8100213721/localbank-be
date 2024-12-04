package com.example.payment_gateway_app.repository;

import com.example.payment_gateway_app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
