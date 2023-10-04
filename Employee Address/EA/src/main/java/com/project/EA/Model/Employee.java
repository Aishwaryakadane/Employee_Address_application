package com.project.EA.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Employee {
    @Id
    private Long employeeId;

    private String employeeFirstName;
    private String employeeLastName;

    @OneToOne
     @JoinColumn(name = "f_Address_Id")
    Address address;
}
