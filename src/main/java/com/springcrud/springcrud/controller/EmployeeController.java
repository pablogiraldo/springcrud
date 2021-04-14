package com.springcrud.springcrud.controller;

import com.springcrud.springcrud.entity.Employee;
import com.springcrud.springcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return  employeeService.saveEmployee(employee);
    }
    @PostMapping("/saveAllEmployees")
    public List<Employee> saveAllEmployees(@RequestBody List<Employee> employees) {
        return  employeeService.saveAllEmployees(employees);
    }
    @GetMapping("/")
    public String index() {
        return "Server running...";
    }
    @GetMapping("/showAllEmployees")
    public List<Employee> showAllEmployee() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/showEmployeeById/{id}")
    public Employee showEmployeeById(@PathVariable int id){
        return  employeeService.getEmployeeById((id));
    }
    @GetMapping("/showEmployeeByName/{employeeName}")
    public Employee showEmployeeByName(@PathVariable String employeeName){
        return  employeeService.getEmployeeByName(employeeName);
    }
    @DeleteMapping("/deleteEmployeeById/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        return  employeeService.deleteEmployeeById((id));
    }
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return  employeeService.updateEmployeeById(employee);
    }

}
