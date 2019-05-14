package com.gorun.repository;

import com.gorun.domain.Employee;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

//使用注解开发 可以不用继承Repository接口
//注解第一个参数是需要调用的类，第二个参数是id的类型
@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository {//extends Repository<Employee,Integer> {
     Employee findByUsername(String username);

     //where username like ?% and age < ?
     public List<Employee> findByUsernameStartingWithAndAgeLessThan(String username,Integer age);
}
