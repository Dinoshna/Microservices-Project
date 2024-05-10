package com.web.sample.poc.dm.service;

import com.web.sample.poc.dm.dao.EmployeeRepo;
import com.web.sample.poc.dm.entity.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class.getName());

    public ResponseEntity<String> addEmployee(Employee employee) {
        try {
            Employee emp = (Employee) employeeRepo.getByName(employee.getName());
            if (emp == null) {
                throw new EntityNotFoundException();
            }
            return new ResponseEntity<String>("Duplicate of data for" + employee.getName(), HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            employeeRepo.save(employee);
            Employee actual_record_created = (Employee) employeeRepo.getByName(employee.getName());
            return new ResponseEntity<String>("Record created for" + employee.getName() + "with id" + actual_record_created.getId(), HttpStatus.OK);
        }
    }

    public ResponseEntity<List<Employee>> getEmployeeById(int id) {
        List<Employee> emp = null;
        try {
            List<Employee> byId = employeeRepo.getById(id);
            log.info(byId + "");
            return new ResponseEntity<List<Employee>>(byId, HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            log.info(emp + "");
            return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
        }
    }

    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<List<Employee>>((List<Employee>) this.employeeRepo.findAll(), HttpStatus.OK);
    }

}
