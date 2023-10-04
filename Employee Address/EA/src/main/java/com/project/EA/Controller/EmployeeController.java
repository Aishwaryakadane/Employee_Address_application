package com.project.EA.Controller;

import com.project.EA.Model.Employee;
import com.project.EA.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getallemployees(){
        return employeeService.getallemployees();
    }

    @GetMapping("employee/{id}")
    public Employee getById(@PathVariable Long id){
        return employeeService.getById(id);
    }

    @PostMapping("employees")
    public String addemployees(@RequestBody Employee emp){
        return employeeService.addemployees(emp);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable Long id) {
        return   employeeService.deleteEmployeeById(id);
    }
}

