package com.gorun;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataTest {
    private ApplicationContext ctx= null;
    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup");
    }
    @After
    public void tearDown(){

    }
    @Test
    public void testEntityManagerFactory(){

    }
}
