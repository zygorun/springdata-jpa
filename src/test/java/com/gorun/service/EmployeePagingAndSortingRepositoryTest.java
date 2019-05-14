package com.gorun.service;

import com.gorun.domain.Employee;
import com.gorun.repository.EmployeePagingAndSortingRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class EmployeePagingAndSortingRepositoryTest {
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository = null;
    private ApplicationContext ctx= null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        employeePagingAndSortingRepository = ctx.getBean(EmployeePagingAndSortingRepository.class);
        System.out.println("setup");
    }

    @Test
    public void testPaging(){
        //按id降序排列
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(0,5,sort);
        Page<Employee> page = employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("查询的总记录："+page.getTotalElements());
        System.out.println("查询总共页数："+page.getTotalPages());
        System.out.println("查询当前第几页："+page.getNumber());
        System.out.println("查询当前页面记录数："+page.getNumberOfElements());
    }

}
