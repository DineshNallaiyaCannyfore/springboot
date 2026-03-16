package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.entity.Employee;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private static final Logger log =
        LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody EmployeeDTO dto) {

        Employee employee = new Employee();
        employee.setEmployeeName(dto.getEmployeeName());
        employee.setEmployeeSalary(dto.getEmployeeSalary());

        return repository.save(employee);
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
      return  employeeService.updateEmployee(id,employee);
  
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
         employeeService.deleteEmployee(id);
           return "Employee deleted successfully";
    }
}