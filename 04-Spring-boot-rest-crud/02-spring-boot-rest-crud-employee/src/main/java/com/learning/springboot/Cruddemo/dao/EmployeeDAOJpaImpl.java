package com.learning.springboot.Cruddemo.dao;

import com.learning.springboot.Cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    //Define Field for entitymanager

    private EntityManager entityManager ;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee",Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee emp = entityManager.find(Employee.class,id);
        return emp;
    }

    @Override
    public Employee save(Employee employee) {

        Employee emp = entityManager.merge(employee);
        return emp;
    }

    @Override
    public void deleteById(int id) {
        Employee emp = entityManager.find(Employee.class,id);

        entityManager.remove(emp);
    }
}
