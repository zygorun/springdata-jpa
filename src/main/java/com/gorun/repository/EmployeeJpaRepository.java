package com.gorun.repository;

import com.gorun.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer> {
}
