package com._520it.crm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com._520it.crm.domain.Employee;
import com._520it.crm.service.IEmployeeService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceImplTest {
	@Autowired
	private IEmployeeService employeeService;
	@Test
	public void testInsert() {
		Employee emp = new Employee();
		emp.setUsername("admin");
		emp.setRealname("超级管理员");
		emp.setPassword("1");
		emp.setAdmin(true);
		emp.setState(Employee.NORMAL);
		emp.setEmail("admin@520it.com");
		employeeService.insert(emp);
	}

}
