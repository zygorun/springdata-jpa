package com.gorun.repository;

import com.gorun.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

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

     @Query("select o from Employee o where o.username = ?1 and o.age = ?2")
     List<Employee> queryParams1(String username, Integer age);

     @Query("select o from Employee o where o.username =:name and o.age =:age")
     List<Employee> queryParams2(@Param("name") String username,@Param("age") Integer age);

     @Query("select o from Employee o where o.username like %?1%")
     List<Employee> queryLike1(String username);

     @Query("select o from Employee o where o.username like %:name%")
     List<Employee> queryLike2(@Param("name")String username);

     @Query(nativeQuery = true,value = "select count(1) from employee")
     long getCount();

     @Modifying
     @Query("update Employee o set username=:name where id=:id")
     void update(@Param("name") String username,@Param("id") Integer id);
}
