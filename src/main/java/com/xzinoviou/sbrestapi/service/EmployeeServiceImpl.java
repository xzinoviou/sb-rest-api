package com.xzinoviou.sbrestapi.service;

import com.xzinoviou.sbrestapi.dao.EmployeeRepository;
import com.xzinoviou.sbrestapi.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found : " + id));
    }

    @Transactional
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
