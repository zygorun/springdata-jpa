package com.gorun.service;

import com.gorun.domain.Employee;
import com.gorun.repository.EmployeeJpaSpecificationExecutorRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class EmployeeJpaSpecificationExecutorRepositoryTest {
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository = null;
    private ApplicationContext ctx= null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        employeeJpaSpecificationExecutorRepository = ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("setup");
    }

    @Test
    public void testPaging(){
        //按id降序排列
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);
        /**
         * root：代表我们要查询的类型(Employee)
         * criteriaQuery：添加查询条件
         * cb：Predicate
         */
        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                //root(Employee(age))
                Path path = root.get("age");

                return cb.gt(path,50);//表示path(age)大于50
            }
        };
        //从第一页开始查 每页查询五条记录
        Pageable pageable = new PageRequest(0,5,sort);
        Page<Employee> page = employeeJpaSpecificationExecutorRepository.findAll(specification,pageable);
        System.out.println("查询的总记录："+page.getTotalElements());
        System.out.println("查询总共页数："+page.getTotalPages());
        System.out.println("查询当前第几页："+page.getNumber());
        System.out.println("查询当前页面记录数："+page.getNumberOfElements());
    }
}
