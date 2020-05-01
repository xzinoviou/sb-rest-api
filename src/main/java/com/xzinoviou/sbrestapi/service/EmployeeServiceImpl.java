package com.xzinoviou.sbrestapi.service;

import com.xzinoviou.sbrestapi.dao.EmployeeDao;
import com.xzinoviou.sbrestapi.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    @Override
    public Employee getById(Long id) {
        return employeeDao.findById(id);
    }

    @Transactional
    @Override
    public List<Employee> getAll() {
        return employeeDao.findAll();
    }

    @Transactional
    @Override
    public Long save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Transactional
    @Override
    public Long update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        employeeDao.delete(id);
    }
}
