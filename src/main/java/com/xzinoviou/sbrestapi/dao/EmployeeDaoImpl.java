package com.xzinoviou.sbrestapi.dao;

import com.xzinoviou.sbrestapi.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Hibernate Dao Implementation fo EmployeeDao interface.
 */

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee findById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee e", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee save(Employee employee) {

        return entityManager.merge(employee);
    }

    @Override
    public Long update(Employee employee) {

        String sql = "update Employee e set e.firstName =: firstName, e.lastName =: lastName, e.email =: email , e.dateOfCreation =: dateOfCreation where e.id =: id ";
        Query query = entityManager.createQuery(sql);
        query.setParameter("firstName", employee.getFirstName());
        query.setParameter("lastName", employee.getLastName());
        query.setParameter("email", employee.getEmail());
        query.setParameter("dateOfCreation", employee.getDateOfCreation());
        query.setParameter("id", employee.getId());

        try {
            query.executeUpdate();
            return employee.getId();
        } catch (RuntimeException e) {
            throw new RuntimeException("Update failed");
        }
    }

    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("delete from Employee e where e.id =: id");
        query.setParameter("id", id);

        try {
            query.executeUpdate();
        } catch (RuntimeException e) {
            throw new RuntimeException("Deletion failed");
        }

    }
}
