package com.gorun.repository;

import com.gorun.domain.Employee;
import org.springframework.data.repository.Repository;

public interface EmployeeRepository extends Repository<Employee,Integer> {
     Employee findByUsername(String username);
}
