package com.app.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
		List<Employee> employees =employeeRepository.findAll();
		return employees;
	}
	
	public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
	
	public Employee getEmployeeById(int id) {
		Employee employee=employeeRepository.findById(id).orElse(null);
        return employee;
    }
	
	public Employee updateEmployee(Employee employee) {
        // Check if the employee with the given ID exists before updating
        if (employeeRepository.existsById(employee.getId())) {
            return employeeRepository.save(employee);
        } else {
            return null; 
        }
    }
	
	public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
	
	public List<Employee> getEmployeeByCity(String city) {
        return employeeRepository.findByCity(city);
	}
}
