package com.springcrud.springcrud.service;

import com.springcrud.springcrud.entity.Employee;
import com.springcrud.springcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // (POST) Save one Employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    // (POST) Save ALL Employees
    public List<Employee> saveAllEmployees(List<Employee> employees) {
        return  employeeRepository.saveAll(employees);
    }
    // (GET) Get all the employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    // (GET) Get one employee by ID
    public  Employee getEmployeeById (int id) {
        return employeeRepository.findById(id).orElse(null);
    }
    // (GET) Get one employee by Name
    public  Employee getEmployeeByName (String employeesName) {
        return employeeRepository.findByName(employeesName);
    }
    // (DELETE) Delete one employee
    public String deleteEmployeeById (int id) {
        employeeRepository.deleteById(id);
        return "employeeDeleted"+id;
    }
    // (PUT) Update Employee
    public Employee updateEmployeeById(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setRole(employee.getRole());
        return employeeRepository.save(existingEmployee);
    }
}

