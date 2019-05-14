package com.gorun.service;

import com.gorun.domain.Employee;
import com.gorun.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

    @Transactional
    public void update(String username, Integer id){
        employeeRepository.update(username,id);
    }

}
