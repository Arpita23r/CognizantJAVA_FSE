package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Employee;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "employeeSummary", types = { Employee.class })
public interface EmployeeSummary {
    String getName();
    String getEmail();
}
