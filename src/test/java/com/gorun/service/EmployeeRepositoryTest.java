package com.gorun.service;

import com.gorun.domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeRepositoryTest {
    private EmployeeService employeeService = null;
    private ApplicationContext ctx= null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        employeeService = ctx.getBean(EmployeeService.class);
        System.out.println("setup");
    }

    @Test
    public void findByUsername(){
        Employee employee = employeeService.findByUsername("gorun");
        System.out.println(employee.getId()+":"+employee.getUsername());
    }

    @Test
    public void update(){
        employeeService.update("My name is gorun",2);
    }
}
