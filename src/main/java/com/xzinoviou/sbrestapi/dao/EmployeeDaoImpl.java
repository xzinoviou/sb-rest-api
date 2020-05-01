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
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee findById(Long id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Employee.class, id);
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

    @Override
    public Long update(Employee employee) {
        Session session = entityManager.unwrap(Session.class);

        String sql = "update Employee e set e.firstName =: firstName, e.lastName =: lastName, e.email =: email , e.dateOfCreation =: dateOfCreation where e.id =: id ";

        Query query = session.createQuery(sql);
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

        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from Employee e where e.id =: id");

        query.setParameter("id", id);

        try {
            query.executeUpdate();
        } catch (RuntimeException e) {
            throw new RuntimeException("Deletion failed");
        }

    }
}
