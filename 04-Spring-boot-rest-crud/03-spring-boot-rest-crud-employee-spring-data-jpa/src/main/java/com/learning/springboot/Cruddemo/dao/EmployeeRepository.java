package com.learning.springboot.Cruddemo.dao;

import com.learning.springboot.Cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
