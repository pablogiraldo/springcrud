package com.springcrud.springcrud.repository;

import com.springcrud.springcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByName(String employeesName);
}
