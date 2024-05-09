package com.web.sample.poc.dm.dao;

import com.web.sample.poc.dm.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
    public List<Employee> getById(int id);
    public List<Employee> getByName(String name);
}
