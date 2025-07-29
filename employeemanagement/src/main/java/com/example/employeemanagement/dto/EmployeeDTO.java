package com.example.employeemanagement.dto;


import lombok.Data;
import lombok.Getter;

@Getter
public class EmployeeDTO {
    private Long id;
    private String name;
    private String department;
    private String email;

    // Constructors
    public EmployeeDTO() {}

    public EmployeeDTO(Long id, String name, String department, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    // Getters & Setters
}