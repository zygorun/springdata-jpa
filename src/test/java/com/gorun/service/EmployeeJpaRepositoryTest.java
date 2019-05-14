package com.gorun.service;

import com.gorun.repository.EmployeeJpaRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeJpaRepositoryTest {
    private EmployeeJpaRepository employeeJpaRepository = null;
    private ApplicationContext ctx= null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }

    @Test
    public void testSave(){
        employeeJpaRepository.findOne(99);
    }
}
