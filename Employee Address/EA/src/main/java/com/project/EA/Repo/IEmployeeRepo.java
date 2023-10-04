package com.project.EA.Repo;

import com.project.EA.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepo extends JpaRepository<Employee, Long> {
}
