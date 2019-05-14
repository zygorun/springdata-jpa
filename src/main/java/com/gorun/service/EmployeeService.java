package com.gorun.service;

import com.gorun.domain.Employee;
import com.gorun.repository.EmployeeCrudRepository;
import com.gorun.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

    @Transactional
    public void update(String username, Integer id){
        employeeRepository.update(username,id);
    }
    @Transactional
    public void save(List<Employee> employeeList){
        employeeCrudRepository.save(employeeList);
    }

}
