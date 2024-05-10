package com.web.sample.poc.emp.controller;

import com.web.sample.poc.emp.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping(path = "/add-employee-data", consumes = "application/json")
    public ResponseEntity<String> postEmployee(@RequestBody Employee employee) {
        String message = restTemplate.postForObject("http://DATABASE-MANAGER-SERVICE/new/emp/add", employee, String.class);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/get/{id}")
    public ResponseEntity<List> getEmployee(@PathVariable("id") int id) {
        List employee = restTemplate.getForObject("http://DATABASE-MANAGER-SERVICE/new/emp/get/" + id, List.class);
        return new ResponseEntity<List>(employee, HttpStatus.OK);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List employee = restTemplate.getForObject("http://DATABASE-MANAGER-SERVICE/new/emp/get/", List.class);
        return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
    }


}
