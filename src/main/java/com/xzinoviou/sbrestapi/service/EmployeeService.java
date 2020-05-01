package com.xzinoviou.sbrestapi.service;

import com.xzinoviou.sbrestapi.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Long save(Employee employee);
}
