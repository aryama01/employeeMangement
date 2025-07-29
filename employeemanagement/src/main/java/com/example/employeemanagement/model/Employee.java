package com.example.employeemanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String department;
    private String email;

    // Constructors
    public Employee() {}

    public Employee(String name, String department, String email) {
        this.name = name;
        this.department = department;
        this.email = email;
    }

    // Getters & Setters
    // (Can be generated using Lombok annotations like @Getter, @Setter if preferred)
}