package com.gorun.repository;

import com.gorun.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

//使用注解开发 可以不用继承Repository接口
//注解第一个参数是需要调用的类，第二个参数是id的类型
@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository {//extends Repository<Employee,Integer> {
     Employee findByUsername(String username);

     //where username like ?% and age < ?
     List<Employee> findByUsernameStartingWithAndAgeLessThan(String username,Integer age);

     //where username like %? and age < ?
     List<Employee> findByUsernameEndingWithAndAgeLessThan(String username,Integer age);

     //where username in(?,?...) or age < ?
     List<Employee> findByUsernameInOrAgeLessThan(List<String> usernames,Integer age);

     //where username in(?,?...) and age < ?
     List<Employee> findByUsernameInAndAgeLessThan(List<String> usernames,Integer age);

     //切记Employee是类名 不是employee表名
     @Query("select o from Employee o where id = (select max(id) from Employee)")
     Employee getEmployeeByMaxId();
}
