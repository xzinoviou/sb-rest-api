package com.xzinoviou.sbrestapi.controller;

import com.xzinoviou.sbrestapi.entity.Employee;
import com.xzinoviou.sbrestapi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @PostMapping
    public Long saveEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
}
