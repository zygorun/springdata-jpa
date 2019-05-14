package com.gorun.repository;


import com.gorun.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryTest {
    private ApplicationContext ctx= null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }
    @After
    public void tearDown(){

    }
    @Test
    public void testFindByName(){
        Employee employee = employeeRepository.findByUsername("gorun");
        System.out.println(employee.getId()+":"+employee.getUsername()+":"+employee.getPassword());
        List<Employee> list = employeeRepository.findByUsernameStartingWithAndAgeLessThan("go",24);
        for (Employee employee1 : list){
            System.out.println(employee1.getId()+":"+employee1.getUsername());
        }
        List<Employee> list1 = employeeRepository.findByUsernameEndingWithAndAgeLessThan("un",24);
        for (Employee employee2 : list1){
            System.out.println(employee2.getId()+":"+employee2.getUsername());
        }
        List<String> usernames = new ArrayList<String>();
        usernames.add("gorun");
        usernames.add("test");
        List<Employee> list2 = employeeRepository.findByUsernameInOrAgeLessThan(usernames,24);
        for (Employee employee3 : list2){
            System.out.println(employee3.getId()+":"+employee3.getUsername());
        }

        List<String> usernames1 = new ArrayList<String>();
        usernames1.add("gorun");
        usernames1.add("test");
        List<Employee> list3 = employeeRepository.findByUsernameInAndAgeLessThan(usernames,24);
        for (Employee employee4 : list3){
            System.out.println(employee4.getId()+":"+employee4.getUsername());
        }

        Employee info = employeeRepository.getEmployeeByMaxId();
        System.out.println(info.getId()+":"+info.getUsername());

        List<Employee> list4 = employeeRepository.queryParams1("gorun",23);
        for (Employee employee5 : list4){
            System.out.println(employee5.getId()+":"+employee5.getUsername());
        }

    }
}
