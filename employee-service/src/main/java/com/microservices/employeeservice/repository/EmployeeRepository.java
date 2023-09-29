package com.microservices.employeeservice.repository;

import com.microservices.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employees
            = new ArrayList<Employee>();

    public Employee addEmployee(Employee employee){
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id){
        return employees.stream()
                .filter(emp -> emp.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAll(){
        return employees;
    }

    public List<Employee> findByDepartement(Long departmentId){
        return employees.stream()
                .filter(emp -> emp.departmentId().equals(departmentId))
                .toList();
    }

}
