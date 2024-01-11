package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.model.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> saveNewEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        updatedEmployee.setId(id);
        Employee employee = employeeService.updateEmployee(updatedEmployee);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/byCity")
    public ResponseEntity<List<Employee>> getEmployeeByCity(@RequestParam String city) {
    	List<Employee> employee = employeeService.getEmployeeByCity(city);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}




















//package com.app.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.model.Employee;
//import com.app.service.EmployeeService;
//
//@RestController
//@RequestMapping("/employees")
//public class EmployeeController {
//
//	@Autowired
//	EmployeeService employeeService;
//
//	@GetMapping
//	public List<Employee> getAllEmployees() {
//		List<Employee> employees = employeeService.getAllEmployee();
//		return employees;
//	}
//
//	@PostMapping
//	public Employee saveEmployee(@RequestBody Employee employee) {
//		Employee savedEmployee = employeeService.saveEmployee(employee);
//		return savedEmployee;
//	}
//
//	@GetMapping("/{id}")
//	public Employee getEmployeeById(@PathVariable int id) {
//		Employee employee = employeeService.getEmployeeById(id);
//		return employee;
//	}
//
//	@PutMapping("/{id}")
//	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
//		updatedEmployee.setId(id);
//		Employee employee = employeeService.updateEmployee(updatedEmployee);
//		return employee;
//	}
//
//	@DeleteMapping("/{id}")
//	public void deleteEmployee(@PathVariable int id) {
//		employeeService.deleteEmployee(id);
//	}
//
//}