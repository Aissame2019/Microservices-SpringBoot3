package com.microservices.departmentservice.controller;

import com.microservices.departmentservice.client.EmployeeClient;
import com.microservices.departmentservice.model.Department;
import com.microservices.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private EmployeeClient employeeClient;

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add : {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("Department find");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("Department find : id={}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("Department find");
        List<Department> departments =
                departmentRepository.findAll();
        departments.forEach(department -> department
                .setEmployees(employeeClient
                        .findByDepartment(department
                                .getId())));
        return departments;
    }

}
