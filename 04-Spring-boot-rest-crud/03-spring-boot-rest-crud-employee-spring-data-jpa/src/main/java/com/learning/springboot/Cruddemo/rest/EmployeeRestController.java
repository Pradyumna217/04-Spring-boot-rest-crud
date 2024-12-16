package com.learning.springboot.Cruddemo.rest;
import com.learning.springboot.Cruddemo.entity.Employee;
import com.learning.springboot.Cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{empId}")
    public Employee getEmployee(@PathVariable int empId){
        Employee emp = employeeService.findById(empId);
        if(emp == null){
            throw new RuntimeException("Employee id not found - " +empId);
        }
        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
//        Just add in case of they pass an id in JSON ... set the id to 0
//        This is to force a save of new item ... insted of update

        employee.setEmpId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.save(employee);
        return emp;
    }

    @DeleteMapping("/employees/{empId}")
    public void deleteEmployee(@PathVariable int empId){
        Employee emp = employeeService.findById(empId);
        if(emp == null){
            throw new RuntimeException("EmployeeId Not Found - "+empId);
        }
        employeeService.deleteById(empId);
    }
}
