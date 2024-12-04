package com.example.payment_gateway_app.service;

import com.example.payment_gateway_app.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public Employee saveEmployee(Employee employee);

    public Employee getEmployeeById(Long id);

    public void deleteEmployeeById(Long id);
}
