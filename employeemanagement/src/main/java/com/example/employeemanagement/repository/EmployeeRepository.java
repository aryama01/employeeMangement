package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // You get built-in methods like save(), findById(), findAll(), delete(), etc.
    // You can also define custom query methods, e.g.:
    // List<Employee> findByDepartment(String department);
}