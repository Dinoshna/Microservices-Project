package com.web.sample.poc.dm.controller;

import com.web.sample.poc.dm.entity.Employee;
import com.web.sample.poc.dm.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/new/emp")
public class DatabaseController {

    @Autowired
    EmployeeService service;

    private static final Logger log = LoggerFactory.getLogger(DatabaseController.class.getName());

    @PostMapping(path="/add", consumes = "application/json")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        log.info("Employee{}: ",employee);
        return service.addEmployee(employee);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable("id") int id){
        return service.getEmployeeById(id);
    }

    @ApiOperation(value="fetchallemp", notes ="get all employees")
    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAllEmployees(@PathVariable("id") int id){
        return service.getEmployeeById(id);
    }
}
