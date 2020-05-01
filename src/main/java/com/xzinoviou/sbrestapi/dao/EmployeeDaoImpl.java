package com.xzinoviou.sbrestapi.dao;

import com.xzinoviou.sbrestapi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Hibernate Dao Implementation fo EmployeeDao interface.
 */

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session.createQuery("from Employee e", Employee.class);

        return query.getResultList();
    }

    @Override
    public Long save(Employee employee) {

        Session session = entityManager.unwrap(Session.class);

        return (Long) session.save(employee);
    }
}
