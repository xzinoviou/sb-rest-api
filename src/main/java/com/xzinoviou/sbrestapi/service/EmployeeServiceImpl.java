package com.xzinoviou.sbrestapi.service;

import com.xzinoviou.sbrestapi.dao.EmployeeDao;
import com.xzinoviou.sbrestapi.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.findAll();
    }
}
