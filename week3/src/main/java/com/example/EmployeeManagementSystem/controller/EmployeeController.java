package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Get all employees with pagination and sorting.
     *
     * @param name The name to search for (optional).
     * @param pageable Pagination and sorting information.
     * @return A page of employees matching the criteria.
     */
    @GetMapping
    public Page<Employee> getAllEmployees(
            @RequestParam(required = false, defaultValue = "") String name,
            Pageable pageable) {
        // Finds employees by name with pagination and sorting.
        return employeeRepository.findByNameContaining(name, pageable);
    }

    /**
     * Get employee by ID.
     *
     * @param id The ID of the employee.
     * @return The employee with the specified ID.
     */
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    /**
     * Create a new employee.
     *
     * @param employee The employee details to create.
     * @return The created employee.
     */
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Update an existing employee.
     *
     * @param id              The ID of the employee to update.
     * @param employeeDetails The updated employee details.
     * @return The updated employee.
     */
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(employeeDetails.getName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setDepartment(employeeDetails.getDepartment());
            return employeeRepository.save(employee);
        }
        return null;
    }

    /**
     * Delete an employee by ID.
     *
     * @param id The ID of the employee to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
