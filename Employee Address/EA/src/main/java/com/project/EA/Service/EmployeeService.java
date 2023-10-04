package com.project.EA.Service;

import com.project.EA.Model.Employee;
import com.project.EA.Repo.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepo employeeRepo;

    public List<Employee> getallemployees() {
        return employeeRepo.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepo.findById(id).orElseThrow();
    }

    public String addemployees(Employee emp) {
         employeeRepo.save(emp);
         return "employee added.......";
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setEmployeeFirstName(updatedEmployee.getEmployeeFirstName());
            existingEmployee.setEmployeeLastName(updatedEmployee.getEmployeeLastName());
            existingEmployee.setAddress(updatedEmployee.getAddress());
            return employeeRepo.save(existingEmployee);
        } else {
            return null;
        }
    }


    public String  deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
        return "Employee is removed!";
    }
}
