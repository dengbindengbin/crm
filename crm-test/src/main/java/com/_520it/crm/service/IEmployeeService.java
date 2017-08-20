package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Employee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;

public interface IEmployeeService {
	int deleteByPrimaryKey(Long id);
    int insert(Employee record);
    Employee selectByPrimaryKey(Long id);
    List<Employee> selectAll();
    int updateByPrimaryKey(Employee record);
	PageResult queryPage(EmployeeQueryObject qo);
	void quit(Long id);

    /**
     * 根据用户名查询员工对象
     * @param username
     * @return
     */
    Employee queryByUsername(String username);
}
