package com.gorun.service;

import com.gorun.domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCrudRepositoryTest {
    private EmployeeService employeeService = null;
    private ApplicationContext ctx= null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        employeeService = ctx.getBean(EmployeeService.class);
        System.out.println("setup");
    }

    @Test
    public void testSave(){
        List<Employee> employees = new ArrayList<>();

        Employee employee = null;
        for (int i=0;i<100;i++){
            employee = new Employee();
            employee.setUsername("gorun"+i);
            employee.setPassword("123456");
            employee.setAge(23+i);
            employees.add(employee);
        }
        employeeService.save(employees);
    }

}
