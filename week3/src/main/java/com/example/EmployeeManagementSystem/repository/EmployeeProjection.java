package com.example.EmployeeManagementSystem.repository;

public class EmployeeProjection {
    private String name;
    private String email;

    public EmployeeProjection(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
	