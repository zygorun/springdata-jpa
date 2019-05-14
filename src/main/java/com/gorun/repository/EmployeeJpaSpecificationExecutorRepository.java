package com.gorun.repository;

import com.gorun.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeJpaSpecificationExecutorRepository extends JpaRepository<Employee,Integer>,JpaSpecificationExecutor<Employee> {
}
