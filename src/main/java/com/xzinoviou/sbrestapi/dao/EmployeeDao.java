package com.xzinoviou.sbrestapi.dao;

import com.xzinoviou.sbrestapi.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Long save(Employee employee);
}
