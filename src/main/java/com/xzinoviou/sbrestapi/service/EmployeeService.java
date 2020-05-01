package com.xzinoviou.sbrestapi.service;

import com.xzinoviou.sbrestapi.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getById(Long id);

    List<Employee> getAll();

    Employee save(Employee employee);

    Long update(Employee employee);

    void delete(Long id);
}
