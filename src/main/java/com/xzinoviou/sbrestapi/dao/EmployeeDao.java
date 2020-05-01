package com.xzinoviou.sbrestapi.dao;

import com.xzinoviou.sbrestapi.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee findById(Long id);

    List<Employee> findAll();

    Long save(Employee employee);

    Long update(Employee employee);

    void delete(Long id);
}
