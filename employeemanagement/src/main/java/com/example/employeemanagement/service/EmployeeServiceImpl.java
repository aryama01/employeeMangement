package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.exception.ResourceNotFoundException;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Helper method to convert Entity to DTO
    private EmployeeDTO convertToDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getDepartment(),
                employee.getEmail()
        );
    }

    // Helper method to convert DTO to Entity
    private Employee convertToEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setDepartment(dto.getDepartment());
        employee.setEmail(dto.getEmail());
        return employee;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = convertToEntity(employeeDTO);
        Employee saved = employeeRepository.save(employee);
        return convertToDTO(saved);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return convertToDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        existing.setName(employeeDTO.getName());
        existing.setDepartment(employeeDTO.getDepartment());
        existing.setEmail(employeeDTO.getEmail());

        return convertToDTO(employeeRepository.save(existing));
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(employee);
    }
}