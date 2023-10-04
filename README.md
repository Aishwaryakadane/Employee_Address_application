
## Overview

This project, the "Employee-Address Application Project," is a Spring Boot application that demonstrates a one-to-one mapping between Employee and Address entities. It provides a set of RESTful API endpoints for creating, retrieving, updating, and deleting employees and addresses. This project serves as a foundation for managing employee data along with their corresponding addresses.

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven

## Data Flow

In the Employee-Address Mapping Project, data flows through various components to handle employee and address operations. Here's an overview of the data flow:

1. **Employee Entity**

   - **Controller Layer**

     The `EmployeeController` handles HTTP requests related to employees and routes them to the `EmployeeService`.

     ```java
     // EmployeeController.java

     @RestController
     @RequestMapping("/employees")
     public class EmployeeController {
         // Define employee-related endpoints and methods
     }
     ```

   - **Service Layer**

     The `EmployeeService` contains business logic and interacts with the `EmployeeRepository` to perform CRUD operations on employee data.

     ```java
     // EmployeeService.java

     @Service
     public class EmployeeService {
         // Implement employee-related service methods
     }
     ```

   - **Repository Layer**

     The `EmployeeRepository` manages data access to the employee entity using Spring Data JPA.

     ```java
     // EmployeeRepository.java

     @Repository
     public interface EmployeeRepository extends JpaRepository<Employee, Long> {
         // Define custom queries or repository methods if needed
     }
     ```

   - **Employee Entity**

     The `Employee` entity represents the structure of employee data in the database.

     ```java
     // Employee.java (Employee Entity)

     @Entity
     public class Employee {
         // Define employee attributes, getters, setters, etc.
     }
     ```

2. **Address Entity**

   - **Controller Layer**

     The `AddressController` handles HTTP requests related to addresses and routes them to the `AddressService`.

     ```java
     // AddressController.java

     @RestController
     @RequestMapping("/addresses")
     public class AddressController {
         // Define address-related endpoints and methods
     }
     ```

   - **Service Layer**

     The `AddressService` contains business logic and interacts with the `AddressRepository` to perform CRUD operations on address data.

     ```java
     // AddressService.java

     @Service
     public class AddressService {
         // Implement address-related service methods
     }
     ```

   - **Repository Layer**

     The `AddressRepository` manages data access to the address entity using Spring Data JPA.

     ```java
     // AddressRepository.java

     @Repository
     public interface AddressRepository extends JpaRepository<Address, Long> {
         // Define custom queries or repository methods if needed
     }
     ```

   - **Address Entity**

     The `Address` entity represents the structure of address data in the database.

     ```java
     // Address.java (Address Entity)

     @Entity
     public class Address {
         // Define address attributes, getters, setters, etc.
     }
     ```

## Database Design

The project's database design includes tables for employees and addresses, each with specific fields. This design ensures data integrity and organized storage.

#### Employee Table

| Column Name | Data Type   | Description                            |
| ----------- | ----------- | -------------------------------------- |
| id          | BIGINT (Primary Key) | Unique identifier for each employee   |
| first_name  | VARCHAR(255) | First name of the employee              |
| last_name   | VARCHAR(255) | Last name of the employee               |

#### Address Table

| Column Name | Data Type   | Description                            |
| ----------- | ----------- | -------------------------------------- |
| id          | BIGINT (Primary Key) | Unique identifier for each address    |
| street      | VARCHAR(255) | Street address of the address           |
| city        | VARCHAR(255) | City where the address is located      |
| state       | VARCHAR(255) | State or region of the address         |
| zipcode     | VARCHAR(20)  | Postal code or ZIP code of the address |
| employee_id | BIGINT (Foreign Key) | Employee ID associated with the address |


## Data Structures

The project utilizes the following data structures to represent employees and address data:

#### Employee Class

The `Employee` class defines the structure for employee data and includes fields such as `id`, `first_name`, and `last_name`.

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Address address;
}
```

#### Address Class

The `Address` class defines the structure for address data and includes fields such as `id`, `street`, `city`, `state`, `zipcode`, and a reference to the associated `Employee`.

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zipcode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
```

## Database Configuration

The project is configured to connect to a MySQL database with the following properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/EA
spring.datasource.username=Your_Username
spring.datasource.password=Your_Password
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
```



