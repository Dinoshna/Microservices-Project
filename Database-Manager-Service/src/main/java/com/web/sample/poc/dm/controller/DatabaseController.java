package com.web.sample.poc.dm.controller;

import com.web.sample.poc.dm.entity.Employee;
import com.web.sample.poc.dm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/new/emp")
public class DatabaseController {

    @Autowired
    EmployeeService service;
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }
}
